/*******************************************************************************
 * Copyright 2012 Geoscience Australia
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package au.gov.ga.earthsci.bookmark;

import au.gov.ga.earthsci.bookmark.model.IBookmarkProperty;

/**
 * An interface for classes that are able to apply the state stored in 
 * 
 * @author James Navin (james.navin@ga.gov.au)
 */
public interface IBookmarkPropertyApplicator
{
	/**
	 * Returns the property types this applicator supports
	 * 
	 * @return The property types this applicator supports
	 */
	String[] getSupportedTypes();
	
	/**
	 * Apply the given property to the current system state
	 * 
	 * @param property The property to apply.
	 * 
	 * @throws IllegalArgumentException If this applicator cannot be used for the given property. See {@link #supports(String)}.
	 */
	void apply(IBookmarkProperty property);
	
	/**
	 * Partially apply the given property to the current system state
	 * by interpolating between the current system state and that defined by
	 * the property, and applying the state at the given percentage along that interpolation.
	 * <p/>
	 * If the percentage is {@code 0} this method will have no effect. A percentage of {@code 1} is
	 * equivalent to calling {@link #apply(IBookmarkProperty)}.
	 * 
	 * @param property The property to apply
	 * @param percent The percent to interpolate between. Must be in the range {@code [0.0, 1.0]}
	 * 
	 * @throws IllegalArgumentException If this applicator cannot be used for the given property
	 */
	void apply(IBookmarkProperty property, double percent);
}