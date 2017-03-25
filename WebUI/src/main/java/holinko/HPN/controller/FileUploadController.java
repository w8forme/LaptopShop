package holinko.HPN.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import holinko.HPN.managers.ShopManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Pavel
 */
@Controller
public class FileUploadController
{

    private static final Logger LOGGER = LoggerFactory
            .getLogger(FileUploadController.class);

    @Autowired
    private ShopManager shopManager;

    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public
    @ResponseBody
    String uploadFileHandler(@RequestParam(value = "id", defaultValue = "") Long id,
                             @RequestParam("file") MultipartFile file, Model model,
                             HttpServletRequest request)
    {
        if (!file.isEmpty())
        {
            String name = file.getOriginalFilename();
            try
            {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = request.getServletContext().getRealPath("");

                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                LOGGER.info("Server File AbsoluteLocation=" + serverFile.getAbsolutePath());
                LOGGER.info("Server File Location=" + serverFile.getPath());
                LOGGER.info("Server File CanonicalLocation=" + serverFile.getCanonicalPath());
                LOGGER.info("product id" + id);
                shopManager.addPhoto(id, serverFile.getCanonicalPath());

                return name;
                //return "You successfully uploaded file=" + name;
            } catch (Exception e)
            {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else
        {
            return "You failed to upload because the file was empty.";
        }
    }
}
