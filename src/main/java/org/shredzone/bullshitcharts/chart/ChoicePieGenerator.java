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
import org.shredzone.bullshitcharts.dataset.Tendency;

/**
 * Creates a pie chart of a given choice of slices. Optionally, one choice can each be
 * favourized or obnoxed, which is important for the {@link Tendency} used.
 * 
 * @author  Richard Körber {@literal dev@shredzone.de}
 * @version $Id: ChoicePieGenerator.java 297 2009-05-07 22:12:58Z shred $
 */
public class ChoicePieGenerator implements PlotGenerator {

    public Plot generate() {
        PieDatasetCreator dataset = new PieDatasetCreator();
        dataset.addChoice("PHP");
        dataset.addChoice("Java");
        dataset.addChoice("C#");
        dataset.addChoice("Python");
        dataset.addChoice("Ruby");

        dataset.setFavouriteChoice("Java");
        dataset.setTendency(Tendency.OPTIMISTIC);

        PiePlot3D plot = new PiePlot3D(dataset.generate());
        plot.setCircular(true);
        plot.setStartAngle(110d);
        plot.setForegroundAlpha(0.6f);
        plot.setDarkerSides(true);
        plot.setOutlineVisible(false);
        return plot;
    }

}
