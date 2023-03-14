News n = new News();
        ArrayList<News> list = n.New_News();
        req.setAttribute("list", list);
        req.getRequestDispatcher("Home.jsp").forward(req, resp);