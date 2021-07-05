package com.adolfo.analizadores.datos;

/**
 *
 * @author hectoradolfo
 */
public class Estilo {

    private String background;
    private String color;
    private String fontZize;
    private String fontFamily;
    private String textAlign;
    private String ship;
    private String div;
    private String button;
    private String areaText;

    public Estilo(String background, String color, String fontZize,
            String fontFamily, String textAlign) {
        this.background = background;
        this.color = color;
        this.fontZize = fontZize;
        this.fontFamily = fontFamily;
        this.textAlign = textAlign;
    }

    // style=" text-align: center;   background: blue; " 

    public String getAreaText() {
        this.areaText = "style=\" font-size: " + this.getFontZize() + "; font-family: " + this.getFontFamily()
                + "; text-align: " + this.getTextAlign() + "; \"  ";
        return this.areaText;
    }
    
    public String getEstiloShip() {
        this.ship = "style=\" font-size: " + this.getFontZize() + "; font-family: " + this.getFontFamily()
                + "; text-align: " + this.getTextAlign() + "; color: " + this.getColor() + "; \"  ";
        return this.ship;
    }

    public String getButton() {
        this.button = "style=\" font-size: " + this.getFontZize() + "; font-family: " + this.getFontFamily()
                + "; text-align: " + this.getTextAlign() + "; color: " + this.getColor() + ";"
                + "  background: " + this.getBackground() + "; \"  ";
        return this.button;
    }

    public String getEstiloDiv() {
        this.div = "style=\" font-size: " + this.getFontZize() + "; font-family: " + this.getFontFamily()
                + "; text-align: " + this.getTextAlign() + "; color: " + this.getColor() + ";"
                + "  background: " + this.getBackground() + "; \"  ";
        return this.div;
    }
    
    

    /**
     * @param background the background to set
     */
    public void setBackground(String background) {
        this.background = background;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @param fontZize the fontZize to set
     */
    public void setFontZize(String fontZize) {
        this.fontZize = fontZize;
    }

    /**
     * @param fontFamily the fontFamily to set
     */
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    /**
     * @param textAlign the textAlign to set
     */
    public void setTextAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    /**
     * @return the background
     */
    public String getBackground() {
        return background;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @return the fontZize
     */
    public String getFontZize() {
        return fontZize;
    }

    /**
     * @return the fontFamily
     */
    public String getFontFamily() {
        return fontFamily;
    }

    /**
     * @return the textAlign
     */
    public String getTextAlign() {
        return textAlign;
    }

}
