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
package org.shredzone.bullshitcharts.chart;

import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.shredzone.bullshitcharts.dataset.LineDatasetCreator;
import org.shredzone.bullshitcharts.dataset.Tendency;

/**
 * Creates a line chart of a given choice of slices. Optionally the chart uses a given
 * {@link Tendency}.
 * 
 * @author  Richard Körber {@literal dev@shredzone.de}
 * @version $Id: LineChartGenerator.java 297 2009-05-07 22:12:58Z shred $
 */
public class LineChartGenerator implements PlotGenerator {

    public Plot generate() {
        LineDatasetCreator dataset = new LineDatasetCreator();
        dataset.setTendency(Tendency.OPTIMISTIC);

        CategoryAxis catAxis = new CategoryAxis("foo");
        ValueAxis valAxis = new NumberAxis("val");
        valAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setBaseShapesVisible(false);
        
        CategoryPlot plot = new CategoryPlot(dataset.generate(), catAxis, valAxis, renderer);
        plot.setDomainGridlinesVisible(true);
        return plot;
    }

}
