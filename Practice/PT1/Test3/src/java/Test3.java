
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author trand
 */
public class Test3 extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = resp.getWriter()){
            //nhap va kiem tra dinh dang
            String err = "";
            String result1 = "";
            String result2 = "";
            int a = 0;
            try{
                a = Integer.parseInt(req.getParameter("a"));
                req.setAttribute("a", String.valueOf(a));
                if(a<3){
                    err = "Must > 3";
                }else{
                    int sum = 0;
                    for(int i=4; i<a; i++){
                        if(i%2==0){
                            result1 += "  "+i;
                            sum += i;
                            result2 = ""+sum;  
                            out.print(result1);
                            out.print(result2);
                        }
                    }
                }
               
            }catch(NumberFormatException e){
                err = "Must be integer number";
            }
            
            req.setAttribute("result1", result1);
            req.setAttribute("result2", result2);
            req.getRequestDispatcher("Test3.jsp").forward(req, resp);
        }catch(Exception ex){
            
        }
    } 
}
