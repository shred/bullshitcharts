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

import org.jfree.chart.plot.Plot;

/**
 * Generates {@link Plot} about a given topic.
 * 
 * @author  Richard Körber {@literal dev@shredzone.de}
 * @version $Id: PlotGenerator.java 297 2009-05-07 22:12:58Z shred $
 */
public interface PlotGenerator {

    /**
     * Generate a {@link Plot}.
     * 
     * @return Generated {@link Plot}
     */
    Plot generate();

}
