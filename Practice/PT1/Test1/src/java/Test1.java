
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
public class Test1 extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = resp.getWriter()){
            //nhap va kiem tra dinh dang
            String result = "";
            int a = 0;
            try{
                a = Integer.parseInt(req.getParameter("a"));
                req.setAttribute("a", String.valueOf(a));
                if(a < 1){
                    result = "Must be > 0";
                }
                for(int i=1 ; i<= a ; i++){
                    if(a%i==0 && (checkSNT(i)) && i<10) {
                        result += "  "+i;
                    }else{
                        result = "Not found!!";
                    }
                }
                out.print(result);
            }catch(NumberFormatException e){
                result = "Must be integer number";
            }
            
            req.setAttribute("result", result);
            req.getRequestDispatcher("Test1.jsp").forward(req, resp);
        }catch(Exception ex){
            
        }
    } 
    
    public static boolean checkSNT(int n){
        if(n>1){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
            return true;
        }
        else 
            return false;
    }
}
