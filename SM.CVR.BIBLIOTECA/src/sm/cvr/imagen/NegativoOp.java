/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.cvr.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase NegativoOp,
 * utilizada para generar el negativo de una imagen usando el metodo filter
 * @author Cristian Vélez Ruiz
 */
public class NegativoOp extends BufferedImageOpAdapter{

    /**
     * Filtro negativo de la imagen
     * @param src Imagen origen
     * @param dest Imagen destino
     * @return Imagen destino
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if (src == null) {
                    throw new NullPointerException("src image is null");
        }
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        
                        
        WritableRaster raster = dest.getRaster();
        double rAnt,bAnt,gAnt,rNuevo,gNuevo,bNuevo;
        
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                //System.out.println("Aplicando negativo");

                rAnt = raster.getSample(x, y, 0);
                gAnt = raster.getSample(x, y, 1);
                bAnt = raster.getSample(x, y, 2);
                
                rNuevo = Math.min(255, 255-rAnt);
                gNuevo = Math.min(255, 255-gAnt);
                bNuevo = Math.min(255, 255-bAnt);
                
                
                raster.setSample(x, y, 0, rNuevo);
                raster.setSample(x, y, 1,gNuevo);
                raster.setSample(x, y, 2,bNuevo);

            }
        }  
        
        return dest;

    }
    
}



