package gntp.project.spring.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("baseController")
public class BaseController {

	@Autowired
	private DataSource dataSource;
	
	@RequestMapping("/test.do")
	public ModelAndView testConnection(Model model) {
		ModelAndView mav = new ModelAndView();
		String viewName = "result";
		mav.setViewName(viewName);
		try {
			Connection con = (Connection)dataSource.getConnection();
			if(con!=null) {
				model.addAttribute("result","connection success!");
				con.close();
			} else {
				model.addAttribute("result","connection fails!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mav;
	}
}
