/**
 * bullshitcharts - A Bullshit Chart Generator
 *
 * Copyright (C) 2009 Richard "Shred" Körber
 *   http://bullshitcharts.shredzone.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.shredzone.bullshitcharts.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.servlet.ServletUtilities;
import org.shredzone.bullshitcharts.chart.AgreementPieGenerator;
import org.shredzone.bullshitcharts.chart.BarChartGenerator;
import org.shredzone.bullshitcharts.chart.ChoicePieGenerator;
import org.shredzone.bullshitcharts.chart.LineChartGenerator;
import org.shredzone.bullshitcharts.chart.PlotGenerator;

/**
 * Servlet that returns a random chart depending on the path name and request parameters.
 * 
 * @author  Richard Körber {@literal dev@shredzone.de}
 * @version $Id: ChartServlet.java 298 2009-05-07 22:24:14Z shred $
 */
public class ChartServlet extends HttpServlet {
    private static final long serialVersionUID = 7200291835832529046L;
    
    private static final int IMAGE_WIDTH = 640;
    private static final int IMAGE_HEIGHT = 480;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
                
        String pathInfo = req.getPathInfo();
        PlotGenerator generator = null;
        if ("/pie.png".equals(pathInfo)) {
            generator = new ChoicePieGenerator();
        } else if ("/agree.png".equals(pathInfo)) {
            generator = new AgreementPieGenerator();
        } else if ("/line.png".equals(pathInfo)) {
            generator = new LineChartGenerator();
        } else if ("/bar.png".equals(pathInfo)) {
            generator = new BarChartGenerator();
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        generator.configure(req);
        
        Plot plot = generator.generate();
        
        // Generate the chart
        JFreeChart chart = new JFreeChart(plot);
        chart.setAntiAlias(true);
        chart.setTextAntiAlias(true);
        chart.setBorderVisible(false);
        chart.removeLegend();

        String title = req.getParameter("title");
        if (title != null) {
            chart.setTitle(title);
        }

        String chartFilename =
                ServletUtilities.saveChartAsPNG(chart, IMAGE_WIDTH, IMAGE_HEIGHT, null);

        // Stream the chart
        resp.setHeader("Cache-Control", "no-cache, must-revalidate");
        resp.setHeader("Expires", "Sat, 01 Jan 2000 00:00:00 GMT");
        ServletUtilities.sendTempFile(chartFilename, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
