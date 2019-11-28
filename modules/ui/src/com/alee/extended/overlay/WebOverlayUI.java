/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.extended.overlay;

import com.alee.api.annotations.NotNull;
import com.alee.api.jdk.Consumer;
import com.alee.managers.style.*;
import com.alee.painter.DefaultPainter;
import com.alee.painter.Painter;
import com.alee.painter.PainterSupport;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;

/**
 * Custom UI for {@link WebOverlay} component.
 *
 * @param <C> component type
 * @author Mikle Garin
 */
public class WebOverlayUI<C extends WebOverlay> extends WOverlayUI<C> implements ShapeSupport, MarginSupport, PaddingSupport
{
    /**
     * Component painter.
     */
    @DefaultPainter ( OverlayPainter.class )
    protected IOverlayPainter painter;

    /**
     * Returns an instance of the {@link WebOverlayUI} for the specified component.
     * This tricky method is used by {@link UIManager} to create component UIs when needed.
     *
     * @param c component that will use UI instance
     * @return instance of the {@link WebOverlayUI}
     */
    public static ComponentUI createUI ( final JComponent c )
    {
        return new WebOverlayUI ();
    }

    @Override
    public void installUI ( @NotNull final JComponent component )
    {
        // Installing UI
        super.installUI ( component );

        // Applying skin
        StyleManager.installSkin ( overlay );
    }

    @Override
    public void uninstallUI ( @NotNull final JComponent component )
    {
        // Uninstalling applied skin
        StyleManager.uninstallSkin ( overlay );

        // Uninstalling UI
        super.uninstallUI ( component );
    }

    @NotNull
    @Override
    public Shape getShape ()
    {
        return PainterSupport.getShape ( overlay, painter );
    }

    @Override
    public boolean isShapeDetectionEnabled ()
    {
        return PainterSupport.isShapeDetectionEnabled ( overlay, painter );
    }

    @Override
    public void setShapeDetectionEnabled ( final boolean enabled )
    {
        PainterSupport.setShapeDetectionEnabled ( overlay, painter, enabled );
    }

    @Override
    public Insets getMargin ()
    {
        return PainterSupport.getMargin ( overlay );
    }

    @Override
    public void setMargin ( final Insets margin )
    {
        PainterSupport.setMargin ( overlay, margin );
    }

    @Override
    public Insets getPadding ()
    {
        return PainterSupport.getPadding ( overlay );
    }

    @Override
    public void setPadding ( final Insets padding )
    {
        PainterSupport.setPadding ( overlay, padding );
    }

    /**
     * Returns overlay painter.
     *
     * @return overlay painter
     */
    public Painter getPainter ()
    {
        return PainterSupport.getPainter ( painter );
    }

    /**
     * Sets overlay painter.
     * Pass null to remove overlay painter.
     *
     * @param painter new overlay painter
     */
    public void setPainter ( final Painter painter )
    {
        PainterSupport.setPainter ( overlay, this, new Consumer<IOverlayPainter> ()
        {
            @Override
            public void accept ( final IOverlayPainter newPainter )
            {
                WebOverlayUI.this.painter = newPainter;
            }
        }, this.painter, painter, IOverlayPainter.class, AdaptiveOverlayPainter.class );
    }

    @Override
    public boolean contains ( final JComponent c, final int x, final int y )
    {
        return PainterSupport.contains ( c, this, painter, x, y );
    }

    @Override
    public int getBaseline ( final JComponent c, final int width, final int height )
    {
        return PainterSupport.getBaseline ( c, this, painter, width, height );
    }

    @Override
    public Component.BaselineResizeBehavior getBaselineResizeBehavior ( final JComponent c )
    {
        return PainterSupport.getBaselineResizeBehavior ( c, this, painter );
    }

    @Override
    public void paint ( final Graphics g, final JComponent c )
    {
        if ( painter != null )
        {
            painter.paint ( ( Graphics2D ) g, c, this, new Bounds ( c ) );
        }
    }

    @Override
    public Dimension getPreferredSize ( final JComponent c )
    {
        return PainterSupport.getPreferredSize ( c, painter );
    }
}