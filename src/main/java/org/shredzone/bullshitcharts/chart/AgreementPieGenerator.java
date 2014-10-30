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

import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.Plot;
import org.shredzone.bullshitcharts.dataset.PieDatasetCreator;

/**
 * Creates a chart showing agreement to a certain topic. The result is a pie chart with
 * "agree", "indecisive" and "disagree" slices.
 *
 * @author Richard "Shred" Körber
 */
public class AgreementPieGenerator extends AbstractPlotGenerator {

    @Override
    public Plot generate() {
        PieDatasetCreator dataset = new PieDatasetCreator();
        dataset.addChoice("disagree");      // TODO: i18n
        dataset.addChoice("indecisive");
        dataset.addChoice("agree");

        dataset.setFavouriteChoice("agree");
        dataset.setObnoxiousChoice("disagree");
        dataset.setTendency(getTendency());

        PiePlot3D plot = new PiePlot3D(dataset.generate());
        plot.setCircular(true);
        plot.setStartAngle(110d);
        plot.setForegroundAlpha(0.6f);
        plot.setDarkerSides(true);
        plot.setOutlineVisible(false);
        return plot;
    }

}
