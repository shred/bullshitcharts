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

import javax.servlet.ServletRequest;

import org.jfree.chart.plot.Plot;

/**
 * Generates {@link Plot} about a given topic.
 *
 * @author Richard "Shred" Körber
 */
public interface PlotGenerator {

    /**
     * Configures the {@link PlotGenerator} using the given {@link ServletRequest}.
     * The plot generator must accept missing or poor parameters, and make up some
     * reasonable values for those parameters.
     *
     * @param req
     *       {@link ServletRequest} containing the parameters.
     */
    void configure(ServletRequest req);

    /**
     * Generate a {@link Plot}.
     *
     * @return Generated {@link Plot}
     */
    Plot generate();

}
