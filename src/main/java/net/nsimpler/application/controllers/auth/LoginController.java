package net.nsimpler.application.controllers.auth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("loginCommand")
@ControllerAdvice("net.nsimpler.application")
@RequestMapping("/auth/login")
public class LoginController {

	static final Logger LOGGER = LoggerFactory.getLogger(LoginCommand.class);

	private static final String LOGIN_FORM = "loginForm";

	@ModelAttribute("loginCommand")
	public LoginCommand formData() {
		return new LoginCommand();
	}

	@ModelAttribute("loginTypes")
	protected List<String> referenceData() throws Exception {
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");

		return loginTypes;
	}

	@ModelAttribute("jobCodes")
	public List<Code> jobCodes() throws Exception {
		return Arrays.asList(new Code("1", "운동선수"), new Code("2", "프로그래머"), new Code("3", "예술가"), new Code("4", "작가"));
	}

	/*
	 * @ModelAttribute("favoriteOsNames") public String[] Oses() throws
	 * Exception{ MemberRegistRequest memberRegistRequest = new
	 * MemberRegistRequest(); String Oses = "윈도우XP,윈도우7";
	 * memberRegistRequest.setFavoriteOs(Oses.split(",")); return
	 * memberRegistRequest.getFavoriteOs();
	 * 
	 * }
	 */
	/*
	 * @ModelAttribute("favoritesOsCodes") public List<String> favoriteOs() {
	 * return Arrays.asList("윈도우XP", "윈도우7", "윈도우8", "맥OS", "우분투"); }
	 */
	@ModelAttribute("favoritesOsCodes")
	public List<Os> Oses() throws Exception {
		return Arrays.asList(new Os(1, "운동선수"), new Os(2, "프로그래머"), new Os(3, "예술가"), new Os(4, "작가"));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(HttpServletResponse response, LoginCommand loginCommand,
			@RequestHeader(value = "Accept", defaultValue = "text/html") String acceptType,
			@CookieValue(value = "auth", required = false) Integer authValue,
			@CookieValue(value = "foo", required = false) String foovalue, Model model) {
		System.out.printf(" LoginController GET.build() 실행 \n");

		LOGGER.debug("#### Success Save User : UserName is  {}, Email is {} ", acceptType, authValue);

		response.addCookie(new Cookie("foo", "zzzzzz"));

		// model.addAttribute("loginCommand",new LoginCommand());

		return LOGIN_FORM;
	}

	/*
	 * @RequestMapping(method = RequestMethod.POST) public String
	 * login(HttpServletResponse response,@ModelAttribute("loginCommand")
	 * LoginCommand loginCommand, BindingResult bindingResult,
	 * HttpServletRequest request) { System.out.printf(
	 * "LoginController POST.build() 실행 \n");
	 * 
	 * response.addCookie(new Cookie("foo", "bar"));
	 * 
	 * System.out.printf("LoginController getEmail : %s \n"
	 * ,loginCommand.getEmail()); System.out.printf(
	 * "LoginController getPassword : %s \n",loginCommand.getPassword());
	 * 
	 * LOGGER.debug("#### Success Save User : UserName is  {}, Email is {} "
	 * ,loginCommand.getEmail(),loginCommand.getPassword());
	 * 
	 * new AuthValidator().validate(loginCommand, bindingResult); if
	 * (bindingResult.hasErrors()) { return LOGIN_FORM; }
	 * 
	 * try {
	 * 
	 * HttpSession session = request.getSession();
	 * 
	 * return "redirect:/index.jsp"; } catch (Exception ex) {
	 * 
	 * return LOGIN_FORM; } }
	 */
	/*
	 * @RequestMapping(method = RequestMethod.POST) public String
	 * login(HttpServletResponse response,@Valid LoginCommand loginCommand,
	 * Errors errors, HttpServletRequest request) { System.out.printf(
	 * "LoginController /test POST.build() 실행 \n");
	 * 
	 * response.addCookie(new Cookie("foo", "bar"));
	 * 
	 * System.out.printf("LoginController getEmail : %s \n"
	 * ,loginCommand.getEmail()); System.out.printf(
	 * "LoginController getPassword : %s \n",loginCommand.getPassword());
	 * 
	 * LOGGER.debug("#### Success Save User : UserName is  {}, Email is {} "
	 * ,loginCommand.getEmail(),loginCommand.getPassword());
	 * 
	 * if(errors.hasErrors()){ return LOGIN_FORM; }
	 * 
	 * try {
	 * 
	 * HttpSession session = request.getSession();
	 * 
	 * return "redirect:/index.jsp"; } catch (Exception ex) {
	 * 
	 * return LOGIN_FORM; } }
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletResponse response, @Valid @ModelAttribute("loginCommand") LoginCommand loginCommand,
			Errors errors, HttpServletRequest request) {
		System.out.printf("LoginController /test POST.build() 실행 \n");

		response.addCookie(new Cookie("foo", "bar"));

		System.out.printf("LoginController getEmail : %s \n", loginCommand.getEmail());
		System.out.printf("LoginController getPassword : %s \n", loginCommand.getPassword());

		LOGGER.debug("#### Success Save User : UserName is  {}, Email is {} ", loginCommand.getEmail(),
				loginCommand.getPassword());

		LOGGER.debug("#### jobCode :  {}", loginCommand.getJobCode());

		LOGGER.debug("#### loginTypes :  {}", loginCommand.getLoginType());

		if (loginCommand.getFavoriteOs() != null) {
			for (int s : loginCommand.getFavoriteOs()) {
				LOGGER.debug("#### getFavoriteOs :  {}", s);
			}
		}

		if (errors.hasErrors()) {

			LOGGER.debug("#### Success hasError ");
			return LOGIN_FORM;
		}

		try {
			/*
			 * Auth auth = new
			 * Auth(loginCommand.getEmail(),loginCommand.getPassword());
			 * 
			 * HttpSession session = request.getSession();
			 * 
			 * session.setAttribute("auth", auth);
			 * 
			 * 
			 */

			LOGGER.debug("#### Success hasError ");

			return "redirect:/index.jsp";
		} catch (Exception ex) {

			return LOGIN_FORM;
		}
	}

	@ExceptionHandler(RuntimeException.class)
	public String handleException(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return "error/exception";
	}
	/*
	 * @InitBinder protected void initBinder(WebDataBinder binder){
	 * //binder.addValidators(new AuthValidator());
	 * 
	 * CustomDateEditor dateEditor = new CustomDateEditor(new
	 * SimpleDateFormat("HH:mm"),false);
	 * 
	 * binder.registerCustomEditor(Date.class,"from", dateEditor);
	 * 
	 * 
	 * 
	 * }
	 */

}
