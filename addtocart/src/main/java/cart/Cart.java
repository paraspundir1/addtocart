package cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String s, goods[] = {"Fifa 15", "Battlefield 5", "GTA 6"};
        double price []={10,20,30};
        double cost;
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
		
		HttpSession session = req.getSession(true);

	    for (int i = 0; i < goods.length; i++) {
	        if (session.getAttribute(goods[i]) == null)
	            session.setAttribute(goods[i], new Integer(0));
	    }

	    if ((s = req.getParameter("fifa")) != null) {
	        int n = ((Integer) session.getAttribute(goods[0])).intValue();
	        session.setAttribute(goods[0], new Integer(n + 1));
	    } else if ((s = req.getParameter("battle")) != null) {
	        int n = ((Integer) session.getAttribute(goods[1])).intValue();
	        session.setAttribute(goods[1], new Integer(n + 1));
	    } else if ((s = req.getParameter("gta")) != null) {
	        int n = ((Integer) session.getAttribute(goods[2])).intValue();
	        session.setAttribute(goods[2], new Integer(n + 1));
	    }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
