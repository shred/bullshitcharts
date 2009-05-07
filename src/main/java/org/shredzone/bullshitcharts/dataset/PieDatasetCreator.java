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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * Creates a random {@link PieDataset}.
 * 
 * @author  Richard Körber {@literal dev@shredzone.de}
 * @version $Id: PieDatasetCreator.java 298 2009-05-07 22:24:14Z shred $
 */
public class PieDatasetCreator {
    
    private List<String> choices = new ArrayList<String>();
    private double[] values = null;
    private int favourite = -1;
    private int obnoxious = -1;
    private Tendency tendency = Tendency.DONTCARE;

    /**
     * Adds a choice to the pie.
     * 
     * @param choice
     *            Choice to be added
     */
    public void addChoice(String choice) {
        choices.add(choice);
    }

    /**
     * Makes a choice the favourite choice. If there is no choice with the given name,
     * nothing happens. Default is no favourized choice.
     * 
     * @param choice
     *            Choice to be favourized.
     */
    public void setFavouriteChoice(String choice) {
        this.favourite = choices.indexOf(choice);
    }

    /**
     * Makes a choice the obnoxed choice. If there is no choice with the given name,
     * nothing happens. Default is no obnoxed choice.
     * 
     * @param choice
     *            Choice to be obnoxed.
     */
    public void setObnoxiousChoice(String choice) {
        this.obnoxious = choices.indexOf(choice);
    }

    /**
     * Sets the {@link Tendency} to be used for this pie. Default is
     * {@value Tendency#DONTCARE}.
     * 
     * @param tendency
     *            {@link Tendency} to be used
     */
    public void setTendency(Tendency tendency) {
        this.tendency = tendency;
    }
    
    /**
     * Generates a {@link PieDataset} out of the given parameters.
     * 
     * @return {@link PieDataset}
     */
    public PieDataset generate() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        values = new double[choices.size()];
        
        switch (tendency) {
        case EUPHORIC:
            setObnoxious(0d, 100d - setFavourite(80d, 100d));
            break;

        case OPTIMISTIC:
            setObnoxious(10d, 95d - setFavourite(40d, 80d));
            break;
            
        case NEUTRAL:
            setFavourite(30d, 50d);
            setObnoxious(30d, 50d);
            break;
            
        case PESSIMISTIC:
            setFavourite(10d, 95d - setObnoxious(40d, 80d));
            break;
            
        case DISASTROUS:
            setFavourite(0d, 100d - setObnoxious(80d, 100d));
            break;
        }
        
        fillValues();
        
        for (int ix = 0; ix < values.length; ix++) {
            dataset.setValue(choices.get(ix), values[ix]);
        }
        
        return dataset;
    }
    
    /**
     * Sets the value of the favourite choice.
     * 
     * @param min
     *            Minimum percentage
     * @param max
     *            Maximum percentage
     * @return Used value
     */
    private double setFavourite(double min, double max) {
        if (favourite >= 0) {
            values[favourite] = (Math.random() * (max - min)) + min;
            return values[favourite];
        } else {
            return min;
        }
    }

    /**
     * Sets the value of the obnoxed choice.
     * 
     * @param min
     *            Minimum percentage
     * @param max
     *            Maximum percentage
     * @return Used value
     */
    private double setObnoxious(double min, double max) {
        if (obnoxious >= 0) {
            values[obnoxious] = (Math.random() * (max - min)) + min;
            return values[obnoxious];
        } else {
            return min;
        }
    }

    /**
     * Fills all choices with random values. The favourite and obnoxed choices are
     * unchanged if set. The other choices will get random percentage values which are
     * (hopefully) evenly distributed, so no choice is preferred.
     */
    private void fillValues() {
        double remain = 100d;
        int numbers = values.length;

        if (tendency != Tendency.DONTCARE) {
            if (favourite >= 0) {
                remain -= values[favourite];
                numbers--;
            }
            if (obnoxious >= 0) {
                remain -= values[obnoxious];
                numbers--;
            }
        }

        Random random = new Random();
        double avg = remain / numbers;
        double max = remain / 10d;
        
        for (int ix = 0; ix < values.length; ix++) {
            if (tendency != Tendency.DONTCARE && (ix == favourite || ix == obnoxious)) {
                continue;
            }
            
            if (numbers > 1) {
                double val = ((random.nextGaussian() * max) + avg);
                if (val < 0) val = 0 ;
                if (val > remain) val = remain;
                values[ix] = val;
                remain -= val;
                numbers--;
            } else {
                values[ix] = remain;
                remain = 0;
            }
        }
    }
    
}
