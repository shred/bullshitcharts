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

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Creates a random {@link CategoryDataset}.
 * 
 * @author  Richard Körber {@literal dev@shredzone.de}
 * @version $Id: LineDatasetCreator.java 297 2009-05-07 22:12:58Z shred $
 */
public class LineDatasetCreator {
    
    private Tendency tendency = Tendency.DONTCARE;

    /**
     * Sets the {@link Tendency} to be used for this dataset. Default is
     * {@value Tendency#DONTCARE}.
     * 
     * @param tendency
     *            {@link Tendency} to be used
     */
    public void setTendency(Tendency tendency) {
        this.tendency = tendency;
    }
    
    /**
     * Generates a {@link CategoryDataset} out of the given parameters.
     * 
     * @return {@link CategoryDataset}
     */
    public CategoryDataset generate() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (int ix = 0; ix < 30; ix++) {
            double val = Math.random();
            dataset.setValue(val, "Foo", String.valueOf(ix));
        }
        
        return dataset;
    }
    
}
