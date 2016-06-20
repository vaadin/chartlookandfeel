package com.vaadin.sebastian;

import javax.servlet.annotation.WebServlet;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("chartstheming")
@Widgetset("com.vaadin.sebastian.ChartsThemingWidgetset")
public class ChartsThemingUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        setContent(layout);

        Chart chart = new Chart();
        chart.setWidth("640px");
        chart.setHeight("480px");

        Configuration configuration = chart.getConfiguration();
        configuration.getChart().setType(ChartType.LINE);

        configuration.getTitle().setText("Number of pigs stopped with birds");

        configuration.getxAxis().setCategories("1.1", "1.2", "1.3", "1.4",
                "2.1", "2.2", "2.3", "2.4", "3.1", "3.2", "3.3", "3.4");

        XAxis xAxis = configuration.getxAxis();
        xAxis.setTitle("Level");

        YAxis yAxis = configuration.getyAxis();
        yAxis.setTitle("Number of pigs");

        ListSeries ls = new ListSeries();
        ls.setName("Red bird");
        ls.setData(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3,
                13.9, 9.6);
        configuration.addSeries(ls);

        ls = new ListSeries();
        ls.setName("Yellow bird");
        ls.setData(3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6,
                4.8);
        configuration.addSeries(ls);

        chart.drawChart(configuration);

        layout.addComponent(chart);

    }

    @WebServlet(urlPatterns = "/*", name = "ChartsThemingServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ChartsThemingUI.class, productionMode = false)
    public static class ChartsThemingServlet extends VaadinServlet {
    }
}
