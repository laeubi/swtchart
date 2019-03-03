/*******************************************************************************
 * Copyright (c) 2017, 2018 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Dr. Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.swtchart.extensions.barcharts;

import org.eclipse.swtchart.extensions.core.IChartSeriesData;

public interface IBarSeriesData extends IChartSeriesData {

	/**
	 * @deprecated use {@link #getSettings()} instead
	 * @return
	 */
	@Deprecated
	IBarSeriesSettings getBarSeriesSettings();

	@Override
	default IBarSeriesSettings getSettings() {

		return getBarSeriesSettings();
	}
}
