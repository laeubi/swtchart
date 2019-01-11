/*******************************************************************************
 * Copyright (c) 2008, 2019 SWTChart project.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * yoshitaka - initial API and implementation
 *******************************************************************************/
package org.eclipse.swtchart;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtchart.util.ChartTestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test case for Grid.
 */
public class GridTest extends ChartTestCase {

	private IGrid xGrid;
	private IGrid yGrid;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		xGrid = chart.getAxisSet().getXAxis(0).getGrid();
		yGrid = chart.getAxisSet().getYAxis(0).getGrid();
	}

	/**
	 * Test for foreground.
	 */
    @Test
	public void testForeground() throws Exception {

		// set null
		xGrid.setForeground(null);
		Color color = xGrid.getForeground();
		Color gray = Display.getDefault().getSystemColor(SWT.COLOR_GRAY);
		assertEquals(gray.getRGB(), color.getRGB());
		showChart();
		yGrid.setForeground(null);
		color = yGrid.getForeground();
		assertEquals(gray.getRGB(), color.getRGB());
		showChart();

		// set color
		Color black = Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
		xGrid.setForeground(black);
		color = xGrid.getForeground();
		assertEquals(black.getRGB(), color.getRGB());
		showChart();
		yGrid.setForeground(black);
		color = yGrid.getForeground();
		assertEquals(black.getRGB(), color.getRGB());
		showChart();

		// set the disposed color
		color = new Color(Display.getDefault(), 0, 0, 0);
		color.dispose();
		try {
			xGrid.setForeground(color);
			fail();
		} catch (IllegalArgumentException e) {
			// expected to reach here
		}
		color = xGrid.getForeground();
		assertEquals(new RGB(0, 0, 0), color.getRGB());
		color = new Color(Display.getDefault(), 0, 0, 0);
		color.dispose();
		try {
			yGrid.setForeground(color);
			fail();
		} catch (IllegalArgumentException e) {
			// expected to reach here
		}
		color = yGrid.getForeground();
		assertEquals(new RGB(0, 0, 0), color.getRGB());
	}

	/**
	 * Test for line style.
	 */
    @Test
	public void testLineStyle() throws Exception {

		// set null
		xGrid.setStyle(null);
		assertEquals(LineStyle.DOT, xGrid.getStyle());
		yGrid.setStyle(null);
		assertEquals(LineStyle.DOT, yGrid.getStyle());

		// set line style
		xGrid.setStyle(LineStyle.SOLID);
		assertEquals(LineStyle.SOLID, xGrid.getStyle());
		showChart();
		xGrid.setStyle(LineStyle.NONE);
		assertEquals(LineStyle.NONE, xGrid.getStyle());
		showChart();
		xGrid.setStyle(LineStyle.DASHDOTDOT);
		assertEquals(LineStyle.DASHDOTDOT, xGrid.getStyle());
		showChart();
		yGrid.setStyle(LineStyle.SOLID);
		assertEquals(LineStyle.SOLID, yGrid.getStyle());
		showChart();
		yGrid.setStyle(LineStyle.NONE);
		assertEquals(LineStyle.NONE, yGrid.getStyle());
		showChart();
		yGrid.setStyle(LineStyle.DASHDOTDOT);
		assertEquals(LineStyle.DASHDOTDOT, yGrid.getStyle());
		showChart();
	}
}
