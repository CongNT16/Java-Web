
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
public class Test2 extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = resp.getWriter()){
            //nhap va kiem tra dinh dang
            String result = "";
            String dauvao = "";
            int n = 0;
            boolean checkdauvao;
            try{
                n = Integer.parseInt(req.getParameter("n"));
                dauvao += n;
                
                if(n <= 2){
                    result = "Must be > 2";
                    checkdauvao = false;
                }else{
                    int count = 0;
                    String daura ="";
                    int dauphay = 0;
                    for(int i=2 ; i<= 10000 ; i++){
                        if(checkPrime(i) == true && i >= n) {                            
                            daura += i ;                           
                            count ++;
                            dauphay ++;
                            if(dauphay < n){
                                daura += ", ";
                            }
                            if(count == n){
                                break;
                            }
                        }
                    }
                    
                    if(count == 0 ){
                        result += "No results";
                    }else{
                        result = daura;
                    }
                }
                
                
                out.print(result);
            }catch(NumberFormatException e){
                result = "Must be integer number";
            }
            
            req.setAttribute("n", dauvao);
            req.setAttribute("result", result);
            req.getRequestDispatcher("Test2.jsp").forward(req, resp);
        }catch(Exception ex){
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    } 
    
    public static boolean checkPrime(int n){
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
