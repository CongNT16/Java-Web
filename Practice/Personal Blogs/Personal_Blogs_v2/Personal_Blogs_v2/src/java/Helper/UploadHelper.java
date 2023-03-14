/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import Models.Posts;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;

/**
 *
 * @author nguye
 */


//    @WebServlet(name = "FileUploadServlet", urlPatterns = {"/fileuploadservlet"})

@MultipartConfig(
            fileSizeThreshold = 1024 * 1024 * 2, // 2MB
            maxFileSize = 1024 * 1024 * 50, // 50MB
            maxRequestSize = 1024 * 1024 * 50) // 50MB



public class UploadHelper extends HttpServlet{
    // This function will single file or multiple files and return list of file url
    // File must be in the form-data with name "file"
    public static String upload(HttpServletRequest request, String destination) {
        String appPath = request.getServletContext().getRealPath("");
        appPath = appPath.replace('\\', '/');
        String relativePath = "assets/images/" + destination;
        String savePath = appPath + relativePath;
//        DebugHelper.print(savePath);
        try {
            // creates the save directory if it does not exists
            java.io.File fileSaveDir = new java.io.File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }
            String fileUrls = "";
            for (Part part : request.getParts()) {
                String fileName = part.getSubmittedFileName();
                if (fileName != null && fileName.length() > 0) {
                    // unique file name with timestamp
                    String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
                    String filePath = savePath + "/" + uniqueFileName;
                    fileUrls += (relativePath + "/" + uniqueFileName);
//                    DebugHelper.print("Write attachment to file: " + filePath);
                    part.write(filePath);
                }
            }
            return fileUrls;
        } catch (Exception e) {
//            DebugHelper.print(e);
//            DebugHelper.print("Upload file failed");
            return null;
        }
    }

}