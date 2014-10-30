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

import org.shredzone.bullshitcharts.dataset.Tendency;

/**
 * Abstract implementation of {@link PlotGenerator}.
 *
 * @author Richard "Shred" Körber
 */
public abstract class AbstractPlotGenerator implements PlotGenerator {

    private ServletRequest req;

    /**
     * Configures the {@link PlotGenerator} using the {@link ServletRequest}
     * parameters.
     *
     * @param req
     *            {@link ServletRequest} containing the parameters
     */
    @Override
    public void configure(ServletRequest req) {
        this.req = req;
    }

    /**
     * Gets the desired resolution, in columns.
     *
     * @return Resolution
     */
    protected int getResolution() {
        String resT = req.getParameter("r");
        if ("0".equals(resT)) {
            return 7;
        } else if ("2".equals(resT)) {
            return 30;
        } else {
            return 12;
        }
    }

    /**
     * Gets the desired amplitude, as a factor between 0.0d and 0.4d.
     *
     * @return Amplitude
     */
    protected double getAmplitude() {
        String resT = req.getParameter("a");
        if ("0".equals(resT)) {
            return 0.0d;
        } else if ("3".equals(resT)) {
            return 0.4d;
        } else if ("1".equals(resT)) {
            return 0.1d;
        } else {
            return 0.2d;
        }
    }

    /**
     * Gets a servlet parameter as value. The string is trimmed if too long. If
     * there was no parameter given, the default value is returned.
     *
     * @param name
     *            Name of the parameter
     * @param def
     *            Default value, may be {@code null}
     * @return Value
     */
    protected String getValue(String name, String def) {
        String val = req.getParameter(name);
        if (val != null) {
            val = val.trim();
            if (val.length() > 10) val = val.substring(0, 10);
        } else {
            val = def;
        }
        return val;
    }

    /**
     * Returns the desired tendency.
     *
     * @return {@link Tendency}
     */
    protected Tendency getTendency() {
        Tendency tendency = Tendency.DONTCARE;

        String paramT = req.getParameter("t");
        if ("-2".equals(paramT)) {
            tendency = Tendency.DISASTROUS;
        } else if ("-1".equals(paramT)) {
            tendency = Tendency.PESSIMISTIC;
        } else if ("0".equals(paramT)) {
            tendency = Tendency.NEUTRAL;
        } else if ("1".equals(paramT)) {
            tendency = Tendency.OPTIMISTIC;
        } else if ("2".equals(paramT)) {
            tendency = Tendency.EUPHORIC;
        }

        return tendency;
    }

}
