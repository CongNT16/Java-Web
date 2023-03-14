/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.TagDAO;
import Models.Tags;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class ManageTagsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String thread = req.getParameter("thread");
        TagDAO t = new TagDAO();

        if (thread.equals("1")) {
            ArrayList<Tags> listTag = (ArrayList<Tags>) t.getListTag();
            req.setAttribute("listTag", listTag);

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_tags.jsp").forward(req, resp);
        }

        if (thread.equals("2")) {

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_tags.jsp").forward(req, resp);

        }

        if (thread.equals("3")) {
            String idtagdel = req.getParameter("idtagdel");

            t.deleteTagByTagId(idtagdel);

            ArrayList<Tags> listTag = (ArrayList<Tags>) t.getListTag();
            req.setAttribute("listTag", listTag);

            req.setAttribute("thread", 1);
            req.getRequestDispatcher("manage_tags.jsp").forward(req, resp);

        }

        if (thread.equals("4")) {
            String idtagedit = req.getParameter("idtagedit");

            Tags tagWithTagId = t.getTagWithTagId(idtagedit);

            req.setAttribute("tag_name", tagWithTagId.getTag_name());

            req.setAttribute("idtagedit", idtagedit);

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_tags.jsp").forward(req, resp);

        }

        if (thread.equals("6")) {
            String tag_name = req.getParameter("tag_name");

            //Tạo 1 id mới
            String tag_id = "";

            while (t.checkTagId(tag_id) == false) {

                Random generator = new Random();
                tag_id = String.valueOf(generator.nextInt((99999 - 10000) + 1) + 10000);

                t.insertTag(tag_id, tag_name);
                break;
            }
            ArrayList<Tags> listTag = (ArrayList<Tags>) t.getListTag();
            req.setAttribute("listTag", listTag);

            req.setAttribute("thread", 1);
            req.getRequestDispatcher("manage_tags.jsp").forward(req, resp);

        }

        if (thread.equals("7")) {
            String tag_id = req.getParameter("idtagedit");
            String tag_name = req.getParameter("tag_name");

            t.updateEditTag(tag_id, tag_name);

            ArrayList<Tags> listTag = (ArrayList<Tags>) t.getListTag();
            req.setAttribute("listTag", listTag);

            req.setAttribute("thread", 1);
            req.getRequestDispatcher("manage_tags.jsp").forward(req, resp);

        }
    }

}
