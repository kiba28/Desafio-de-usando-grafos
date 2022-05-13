package com.desafiodev.builders;

import com.desafiodev.entities.Route;

public class RouteBuilder {

	public static Route getRoute() {
		Route route = new Route(1L, "A", "B", 5);
		return route;
	}

	public static Route getRoute2() {
		Route route = new Route(2L, "B", "C", 4);
		return route;
	}

	public static Route getRoute3() {
		Route route = new Route(3L, "C", "D", 8);
		return route;
	}

	public static Route getRoute4() {
		Route route = new Route(4L, "D", "C", 8);
		return route;
	}

	public static Route getRoute5() {
		Route route = new Route(5L, "D", "E", 6);
		return route;
	}

	public static Route getRoute6() {
		Route route = new Route(6L, "A", "D", 5);
		return route;
	}

	public static Route getRoute7() {
		Route route = new Route(7L, "C", "E", 2);
		return route;
	}

	public static Route getRoute8() {
		Route route = new Route(8L, "E", "B", 3);
		return route;
	}

	public static Route getRoute9() {
		Route route = new Route(9L, "A", "E", 7);
		return route;
	}
}
