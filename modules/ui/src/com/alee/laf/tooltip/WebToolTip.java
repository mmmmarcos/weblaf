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

package com.alee.laf.tooltip;

import com.alee.managers.log.Log;
import com.alee.managers.style.*;
import com.alee.painter.Paintable;
import com.alee.painter.Painter;
import com.alee.utils.swing.extensions.FontMethods;
import com.alee.utils.swing.extensions.FontMethodsImpl;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * This {@link JToolTip} extension class provides a direct access to WebToolTipUI methods.
 *
 * @author Mikle Garin
 */

public class WebToolTip extends JToolTip
        implements Styleable, Paintable, ShapeProvider, MarginSupport, PaddingSupport, FontMethods<WebToolTip>
{
    /**
     * Constructs empty tooltip.
     */
    public WebToolTip ()
    {
        super ();
    }

    @Override
    public StyleId getStyleId ()
    {
        return StyleManager.getStyleId ( this );
    }

    @Override
    public StyleId setStyleId ( final StyleId id )
    {
        return StyleManager.setStyleId ( this, id );
    }

    @Override
    public StyleId resetStyleId ()
    {
        return StyleManager.resetStyleId ( this );
    }

    @Override
    public Skin getSkin ()
    {
        return StyleManager.getSkin ( this );
    }

    @Override
    public Skin setSkin ( final Skin skin )
    {
        return StyleManager.setSkin ( this, skin );
    }

    @Override
    public Skin setSkin ( final Skin skin, final boolean recursively )
    {
        return StyleManager.setSkin ( this, skin, recursively );
    }

    @Override
    public Skin resetSkin ()
    {
        return StyleManager.resetSkin ( this );
    }

    @Override
    public void addStyleListener ( final StyleListener listener )
    {
        StyleManager.addStyleListener ( this, listener );
    }

    @Override
    public void removeStyleListener ( final StyleListener listener )
    {
        StyleManager.removeStyleListener ( this, listener );
    }

    @Override
    public Map<String, Painter> getCustomPainters ()
    {
        return StyleManager.getCustomPainters ( this );
    }

    @Override
    public Painter getCustomPainter ()
    {
        return StyleManager.getCustomPainter ( this );
    }

    @Override
    public Painter getCustomPainter ( final String id )
    {
        return StyleManager.getCustomPainter ( this, id );
    }

    @Override
    public Painter setCustomPainter ( final Painter painter )
    {
        return StyleManager.setCustomPainter ( this, painter );
    }

    @Override
    public Painter setCustomPainter ( final String id, final Painter painter )
    {
        return StyleManager.setCustomPainter ( this, id, painter );
    }

    @Override
    public boolean resetPainter ()
    {
        return StyleManager.resetPainter ( this );
    }

    @Override
    public Shape provideShape ()
    {
        return getWebUI ().provideShape ();
    }

    @Override
    public Insets getMargin ()
    {
        return getWebUI ().getMargin ();
    }

    /**
     * Sets new margin.
     *
     * @param margin new margin
     */
    public void setMargin ( final int margin )
    {
        setMargin ( margin, margin, margin, margin );
    }

    /**
     * Sets new margin.
     *
     * @param top    new top margin
     * @param left   new left margin
     * @param bottom new bottom margin
     * @param right  new right margin
     */
    public void setMargin ( final int top, final int left, final int bottom, final int right )
    {
        setMargin ( new Insets ( top, left, bottom, right ) );
    }

    @Override
    public void setMargin ( final Insets margin )
    {
        getWebUI ().setMargin ( margin );
    }

    @Override
    public Insets getPadding ()
    {
        return getWebUI ().getPadding ();
    }

    /**
     * Sets new padding.
     *
     * @param padding new padding
     */
    public void setPadding ( final int padding )
    {
        setPadding ( padding, padding, padding, padding );
    }

    /**
     * Sets new padding.
     *
     * @param top    new top padding
     * @param left   new left padding
     * @param bottom new bottom padding
     * @param right  new right padding
     */
    public void setPadding ( final int top, final int left, final int bottom, final int right )
    {
        setPadding ( new Insets ( top, left, bottom, right ) );
    }

    @Override
    public void setPadding ( final Insets padding )
    {
        getWebUI ().setPadding ( padding );
    }

    /**
     * Returns Web-UI applied to this class.
     *
     * @return Web-UI applied to this class
     */
    private WebToolTipUI getWebUI ()
    {
        return ( WebToolTipUI ) getUI ();
    }

    /**
     * Installs a Web-UI into this component.
     */
    @Override
    public void updateUI ()
    {
        if ( getUI () == null || !( getUI () instanceof WebToolTipUI ) )
        {
            try
            {
                setUI ( UIManager.getUI ( this ) );
            }
            catch ( final Throwable e )
            {
                Log.error ( this, e );
                setUI ( new WebToolTipUI () );
            }
        }
        else
        {
            setUI ( getUI () );
        }
    }

    @Override
    public WebToolTip setPlainFont ()
    {
        return FontMethodsImpl.setPlainFont ( this );
    }

    @Override
    public boolean isPlainFont ()
    {
        return FontMethodsImpl.isPlainFont ( this );
    }

    @Override
    public WebToolTip setPlainFont ( final boolean apply )
    {
        return FontMethodsImpl.setPlainFont ( this, apply );
    }

    @Override
    public WebToolTip setBoldFont ()
    {
        return FontMethodsImpl.setBoldFont ( this );
    }

    @Override
    public boolean isBoldFont ()
    {
        return FontMethodsImpl.isBoldFont ( this );
    }

    @Override
    public WebToolTip setBoldFont ( final boolean apply )
    {
        return FontMethodsImpl.setBoldFont ( this, apply );
    }

    @Override
    public WebToolTip setItalicFont ()
    {
        return FontMethodsImpl.setItalicFont ( this );
    }

    @Override
    public boolean isItalicFont ()
    {
        return FontMethodsImpl.isItalicFont ( this );
    }

    @Override
    public WebToolTip setItalicFont ( final boolean apply )
    {
        return FontMethodsImpl.setItalicFont ( this, apply );
    }

    @Override
    public WebToolTip setFontStyle ( final boolean bold, final boolean italic )
    {
        return FontMethodsImpl.setFontStyle ( this, bold, italic );
    }

    @Override
    public WebToolTip setFontStyle ( final int style )
    {
        return FontMethodsImpl.setFontStyle ( this, style );
    }

    @Override
    public WebToolTip changeFontSize ( final int change )
    {
        return FontMethodsImpl.changeFontSize ( this, change );
    }

    @Override
    public int getFontSize ()
    {
        return FontMethodsImpl.getFontSize ( this );
    }

    @Override
    public WebToolTip setFontSize ( final int fontSize )
    {
        return FontMethodsImpl.setFontSize ( this, fontSize );
    }

    @Override
    public WebToolTip setFontSizeAndStyle ( final int fontSize, final boolean bold, final boolean italic )
    {
        return FontMethodsImpl.setFontSizeAndStyle ( this, fontSize, bold, italic );
    }

    @Override
    public WebToolTip setFontSizeAndStyle ( final int fontSize, final int style )
    {
        return FontMethodsImpl.setFontSizeAndStyle ( this, fontSize, style );
    }

    @Override
    public String getFontName ()
    {
        return FontMethodsImpl.getFontName ( this );
    }

    @Override
    public WebToolTip setFontName ( final String fontName )
    {
        return FontMethodsImpl.setFontName ( this, fontName );
    }
}