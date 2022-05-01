package com.controller;
import jakarta.servlet.http.*;

import java.io.IOException;
import com.bean.Player;
import com.service.PlayerService;

import jakarta.servlet.*;

public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PlayerService playerService = new PlayerService();
	private Player player;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//grabs the denoted action for the servlet
		String action = req.getServletPath();
		if (action.equals("/login")) {
			
			//STEAM_ID & search option are needed in order to search properly
			String STEAM_NAME_ID = req.getParameter("STEAM_NAME_ID");
			String searchOption = req.getParameter("search-option");
			Long STEAM_ID =-1L;
			
			//nothing entered and submitted
			if(searchOption==null || STEAM_NAME_ID ==null || STEAM_NAME_ID.isBlank()) {
				req.getSession().setAttribute("error", new String("No values entered!"));
				dispatch(req, res, "/index.jsp");
				return;
			}
			
			//if search by vanity name is selected 
			if(searchOption.equals("STEAM_NAME")) {
				
				STEAM_ID = playerService.getSteamID(STEAM_NAME_ID);
				if(STEAM_ID==-1) {
					req.getSession().setAttribute("error", new String("Steam name Not found!"));
					dispatch(req,res,"/index.jsp");
					return;
				}
				String STEAM_NAME =playerService.getProfileName(STEAM_ID);
				player = playerService.createPlayer(STEAM_NAME, STEAM_ID);
			}
			//if search by ID is selected
			else if(searchOption.equals("STEAM_ID")){
				try {
					STEAM_ID = Long.parseLong(req.getParameter("STEAM_NAME_ID"));
					String STEAM_NAME =playerService.getProfileName(STEAM_ID);
					player = playerService.createPlayer(STEAM_NAME, STEAM_ID);
				}
				catch(NumberFormatException e) {
					req.getSession().setAttribute("error", new String("Illegal Characters for Steam ID"));
					dispatch(req,res,"/index.jsp");
					return;
				}
			}
			req.getSession().setAttribute("player", player);
			dispatch(req,res,"/ShowInfo.jsp");
		}
	}

	protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}