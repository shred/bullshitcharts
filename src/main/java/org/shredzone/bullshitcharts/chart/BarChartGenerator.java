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
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.Range;
import org.shredzone.bullshitcharts.dataset.LineDatasetCreator;
import org.shredzone.bullshitcharts.dataset.Tendency;

/**
 * Creates a bar chart of a given choice of slices. Optionally the chart uses a given
 * {@link Tendency}.
 * 
 * @author Richard Körber {@literal dev@shredzone.de}
 * @version $Id: BarChartGenerator.java 579 2011-07-30 16:18:39Z shred $
 */
public class BarChartGenerator extends AbstractPlotGenerator {

    @Override
    public Plot generate() {
        LineDatasetCreator dataset = new LineDatasetCreator();
        dataset.setTendency(getTendency());
        dataset.setNumberOfValues(getResolution());
        dataset.setAmplitude(getAmplitude());

        CategoryAxis catAxis = new CategoryAxis(getValue("x", "Time")); // TODO: i18n
        catAxis.setLowerMargin(0.0d);
        catAxis.setUpperMargin(0.0d);
        catAxis.setTickMarksVisible(false);
        catAxis.setTickLabelsVisible(false);
        
        ValueAxis valAxis = new NumberAxis(getValue("y", "Value"));
        valAxis.setRange(new Range(0.0d, 1.05d));
        valAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        valAxis.setTickMarksVisible(false);
        valAxis.setTickLabelsVisible(false);
        
        BarRenderer3D renderer = new BarRenderer3D();
        
        CategoryPlot plot = new CategoryPlot(dataset.generate(), catAxis, valAxis, renderer);
        plot.setDomainGridlinesVisible(false);
        plot.setRangeGridlinesVisible(false);
        return plot;
    }

}
