package com.ships.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.ShipService;
import com.ships.services.OrderInfoService;
import com.ships.services.ShippingCompanyService;

@Controller
public class OrderInfoController {
	@Autowired
	OrderInfoService orderInfoService;

	@Autowired
	ShippingCompanyService shippingCompanyService;

	@Autowired
	ShipService shipService;

	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String listOrders(Model model) {

		List<OrderInfo> orderInfos = orderInfoService.findAll();
		model.addAttribute("orderInfos", orderInfos);

		return "showOrderInfo";
	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String createOrderGET(Model model) {

		Map<Integer, String> shippingCompanyList = ShipCompanyList();
		model.addAttribute("shippingCompanyList", shippingCompanyList);

		Map<Integer, String> shipList = ShipList();
		model.addAttribute("shipList", shipList);

		OrderInfo orderInfo = new OrderInfo();
		model.addAttribute("orderInfo", orderInfo);

		return "addOrderInfo";
	}

	private Map<Integer, String> ShipList() {
		ArrayList<Ship> ships = (ArrayList<Ship>) shipService.findAll();
		Map<Integer, String> shipList = new HashMap<Integer, String>();

		for (Ship c : ships) {
			shipList.put(c.getSid(), c.getName() + "; " + c.getCost().toString());
		}

		return shipList;
	}

	private Map<Integer, String> ShipCompanyList() {
		ArrayList<ShippingCompany> shippingCompanies = (ArrayList<ShippingCompany>) shippingCompanyService.findAll();
		Map<Integer, String> shippingCompanyList = new HashMap<Integer, String>();

		for (ShippingCompany c : shippingCompanies) {
			shippingCompanyList.put(c.getScid(), c.getName() + "; " + c.getBalance().toString());
		}

		return shippingCompanyList;
	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String addOrderPOST(@Valid @ModelAttribute("orderInfo") OrderInfo orderInfo, BindingResult result,
			Model model) {
		boolean isBalanceSmaller;
		BigDecimal shipCost = orderInfo.getShip().getCost();
		BigDecimal shipCompanyBalance = orderInfo.getShippingCompany().getBalance();

		int comp = shipCost.compareTo(shipCompanyBalance);
		if (comp == 1)
			isBalanceSmaller = true;
		else
			isBalanceSmaller = false;

		if (result.hasErrors())
			return "emptyInput";
		else if (isBalanceSmaller)
			return "balanceCostComparison";

		return "showOrderInfo";
	}
}
