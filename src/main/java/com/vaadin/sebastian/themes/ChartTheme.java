package com.vaadin.sebastian.themes;

import com.vaadin.addon.charts.model.style.Color;
import com.vaadin.addon.charts.model.style.GradientColor;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.addon.charts.model.style.Style;
import com.vaadin.addon.charts.model.style.Theme;

public class ChartTheme extends Theme {

    public ChartTheme() {
        Color[] colors = new Color[2];
        colors[0] = new SolidColor("#d62031");
        colors[1] = new SolidColor("#f0dc1e");
        setColors(colors);

        GradientColor color = GradientColor.createLinear(0, 0, 0, 1);
        color.addColorStop(0, new SolidColor("#444444"));
        color.addColorStop(1, new SolidColor("#000000"));
        getChart().setBackgroundColor(color);
        getLegend().setBackgroundColor(new SolidColor("#000000"));

        Style greenTextStyle = new Style();
        greenTextStyle.setColor(new SolidColor("#88b922"));
        getxAxis().setLabels(greenTextStyle);
        getxAxis().setTitle(greenTextStyle);
        getyAxis().setLabels(greenTextStyle);
        getyAxis().setTitle(greenTextStyle);
        setTitle(greenTextStyle);
        getLegend().setItemStyle(greenTextStyle);

        Style itemHoverStyle = new Style();
        itemHoverStyle.setColor(new SolidColor("#f0dc1e"));
        getLegend().setItemHoverStyle(itemHoverStyle);

    }

}
