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
package org.shredzone.bullshitcharts.dataset;

/**
 * Tendency that the chart tries to express. Use this to forge the statistics so it shows
 * the result you actually need.
 * 
 * @author  Richard Körber {@literal dev@shredzone.de}
 * @version $Id: Tendency.java 298 2009-05-07 22:24:14Z shred $
 */
public enum Tendency {
    
    /**
     * The chart is truly random.
     */
    DONTCARE,

    /**
     * The chart shows a disastrous development. A pie shows the favoured slice being
     * much smaller than the obnoxious slice, which is the largest slice. A graph shows
     * a massive drop towards the end.
     */
    DISASTROUS,

    /**
     * The chart shows a rather pessimistic development. A pie shows the favoured slice
     * being smaller than the obnoxious slice. A graph shows a slight tendency to fall.
     */
    PESSIMISTIC,

    /**
     * The chart shows a neutral development. A pie shows the favoured and most obnoxious
     * slice with about the same percentage. A graph is more or less horizontal.
     */
    NEUTRAL,

    /**
     * The chart shows a rather optimistic development. A pie shows the favoured slice
     * being bigger than most obnoxious slice. A graph shows a slight tendency to rise.
     */
    OPTIMISTIC,

    /**
     * The chart shows an euphoric development. A pie shows the favoured slice massively
     * winning over all other slices. A graph shows a massive raise toward the end.
     */
    EUPHORIC;

}
