import java.awt.Frame;
import java.awt.*;
import java.awt.geom.*;
import java.util.Date;


// HI MA'AM! MA'AM GUMAGANDA LNG UNG BACKGROUND AFTER 1ST SIMULATION :D
//


public class FourWayTraffic_TOBIAS extends Frame{

    
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(3.0f));
        
        Image img1 = Toolkit.getDefaultToolkit().getImage("intersection.jpg");
        g2d.drawImage(img1, 0, 0, 950, 681, this);
        
        GeneralPath road = new GeneralPath();
        GeneralPath light = new GeneralPath();
        GeneralPath inter = new GeneralPath();
        GeneralPath road1 = new GeneralPath();
        
        
        Ellipse2D red2 = new Ellipse2D.Double(245,142,25,25);
        Ellipse2D yellow2 = new Ellipse2D.Double(275,142,25,25);
        Ellipse2D green2 = new Ellipse2D.Double(305,142,25,25);
        
        Ellipse2D red4 = new Ellipse2D.Double(625,80,25,25);
        Ellipse2D yellow4 = new Ellipse2D.Double(625,110,25,25);
        Ellipse2D green4 = new Ellipse2D.Double(625,140,25,25);
        
        Ellipse2D red3 = new Ellipse2D.Double(620,530,25,25);
        Ellipse2D yellow3 = new Ellipse2D.Double(650,530,25,25);
        Ellipse2D green3 = new Ellipse2D.Double(680,530,25,25);
        
        Ellipse2D red1 = new Ellipse2D.Double(305,515,25,25);
        Ellipse2D yellow1 = new Ellipse2D.Double(305,545,25,25);
        Ellipse2D green1 = new Ellipse2D.Double(305,575,25,25);
       
        
        g2d.setColor(Color.red);
        g2d.fill(red4);
        g2d.fill(red3);
        g2d.fill(red2);
        //g2d.fill(red1);
        /*
        g2d.setColor(Color.yellow);
        g2d.fill(yellow4);
        g2d.fill(yellow3);
        g2d.fill(yellow2);
        g2d.fill(yellow1);
        g2d.setColor(Color.green);
        g2d.fill(green4);
        g2d.fill(green3);
        g2d.fill(green2);
        g2d.fill(green1);
        */
        
        //CAR
        
        GeneralPath car = new GeneralPath();
        car.moveTo(60-20, 120-20);
        car.lineTo(80-20, 120-20);
        car.quadTo(90-20, 140-20, 100-20, 120-20);
        car.lineTo(160-20, 120-20);
        car.quadTo(170-20, 140-20, 180-20, 120-20);
        car.lineTo(200-20, 120-20);
        car.curveTo(195-20, 100-20, 200-20, 80-20, 160-20, 80-20);
        car.lineTo(110-20, 80-20);
        car.lineTo(90-20, 100-20);
        car.lineTo(60-20, 100-20);
        car.lineTo(60-20, 120-20);
        
        
        Ellipse2D.Double green_5 = new Ellipse2D.Double(220, 770, 60, 60);
        g2d.draw(green_5);
        
        AffineTransform translate = new AffineTransform();
        AffineTransform scaling = new AffineTransform();
        
        // LEFT CAR
        AffineTransform scale = new AffineTransform(); 
        scale.setToScale(-1,1);
        g2d.setPaint(Color.BLUE);
        g2d.fill(scale.createTransformedShape(car));
        
        AffineTransform trans = new AffineTransform();
        trans.setToTranslation(200,200);
        g2d.fill(trans.createTransformedShape(scale.createTransformedShape(car)));
        
        //RIGHT CAR
        AffineTransform scale1 = new AffineTransform(); 
        scale1.setToScale(1,1);
        g2d.setPaint(Color.BLUE);
        g2d.fill(scale.createTransformedShape(car));
        
        AffineTransform trans1 = new AffineTransform();
        trans1.setToTranslation(750,325);
        g2d.fill(trans1.createTransformedShape(scale1.createTransformedShape(car)));
        
        // BOT CAR
        AffineTransform rotate = new AffineTransform(); 
        translate.setToTranslation(515,555);
        rotate.setToRotation(Math.PI/2);
        g2d.fill(translate.createTransformedShape(scaling.createTransformedShape(rotate.createTransformedShape(car))));
        
    
        
        int i = 750;
        g2d.setPaint(Color.GREEN);
        g2d.fill(green1);
        for(int x = 0 ; x < 20 ; x++){
            g2d.setPaint(Color.BLACK);
            translate.setToTranslation(i, 325);
            g2d.fill(translate.createTransformedShape((car)));
            i -= 40;
            g2d.setPaint(Color.BLUE);
            translate.setToTranslation(i, 325);
            g2d.fill(translate.createTransformedShape((car)));
            sustain(500);
            
            if (i == 200) {
                g2d.fill(green1);
                g2d.setPaint(Color.YELLOW);
                g2d.fill(yellow1);
            }
        }
        g2d.setPaint(Color.BLACK);
        g2d.fill(yellow1);
        g2d.fill(green1);
        g2d.setPaint(Color.RED);
        g2d.fill(red1);
     
       
        // MID - RIGHT
        int i2 = 200;
        g2d.setPaint(Color.BLACK);
        g2d.fill(red4);
        g2d.setPaint(Color.GREEN);
        g2d.fill(green4);
        for(int x = 0 ; x < 20 ; x++){
            g2d.setPaint(Color.BLACK);
            trans.setToTranslation(i2, 200);
            g2d.fill(trans.createTransformedShape(scale.createTransformedShape(car)));
            i2 += 40;
            g2d.setPaint(Color.BLUE);
            trans.setToTranslation(i2, 200);
            g2d.fill(trans.createTransformedShape(scale.createTransformedShape(car)));
            sustain(500);
            
            if (i2 == 500) {
                g2d.fill(green4);
                g2d.setPaint(Color.YELLOW);
                g2d.fill(yellow3);
            }
        }
        g2d.setPaint(Color.BLACK);
        g2d.fill(yellow4);
        g2d.fill(green4);
        g2d.setPaint(Color.RED);
        g2d.fill(red4);
        
        g2d.setPaint(Color.BLACK);
        g2d.fill(red2); 
        
       
        
        //BOT CAR - going upwards
       int i3 = 555;
        g2d.setPaint(Color.GREEN);
        g2d.fill(green2);
        for(int x = 0 ; x < 20 ; x++){
            g2d.setPaint(Color.BLACK);
            translate.setToTranslation(515, i3);
            g2d.fill(translate.createTransformedShape(scaling.createTransformedShape(rotate.createTransformedShape(car))));
            i3 -= 40;
            g2d.setPaint(Color.BLUE);
            translate.setToTranslation(515, i3);
            g2d.fill(translate.createTransformedShape(scaling.createTransformedShape(rotate.createTransformedShape(car))));
            sustain(500);
            
            if (i3 == 400) {
                g2d.fill(green2);
                g2d.setPaint(Color.YELLOW);
                g2d.fill(yellow2);
            }
        }
        g2d.setPaint(Color.BLACK);
        g2d.fill(yellow2);
        g2d.fill(green2);
        g2d.setPaint(Color.RED);
        g2d.fill(red2);
        
        //UPPER CAR GOING BOT
         rotate.setToRotation(Math.PI/2);
        translate.setToTranslation(430,50);
        scaling.setToScale(-1, -1);
        g2d.fill(translate.createTransformedShape(scaling.createTransformedShape(rotate.createTransformedShape(car)))); 
        int i4 = 100;
        g2d.setPaint(Color.GREEN);
        g2d.fill(green3);
        for(int x = 0 ; x < 20 ; x++){
            g2d.setPaint(Color.BLACK);
            translate.setToTranslation(430, i4);
            g2d.fill(translate.createTransformedShape(scaling.createTransformedShape(rotate.createTransformedShape(car))));
            i4 += 40;
            g2d.setPaint(Color.BLUE);
            translate.setToTranslation(430, i4);
            g2d.fill(translate.createTransformedShape(scaling.createTransformedShape(rotate.createTransformedShape(car))));
            sustain(500);
            
            if (i4 == 500) {
                g2d.fill(green3);
                g2d.setPaint(Color.YELLOW);
                g2d.fill(yellow3);
            }
        }
        g2d.setPaint(Color.BLACK);
        g2d.fill(yellow3);
        g2d.fill(green3);
        g2d.setPaint(Color.RED);
        g2d.fill(red3);
        
        
        /*
        //STOPLIGHT 1
        
        light.moveTo(375, 375);
        light.lineTo(375, 325);
        light.lineTo(275, 325);
        light.lineTo(275, 375);
        
        g2d.setPaint(Color.blue);
        g2d.draw(light);
        g2d.fill(light);
        
        //STOPLIGHT 2
        light.moveTo(625, 375);
        light.lineTo(625, 275);
        light.lineTo(675, 275);
        light.lineTo(675, 375);
        
        g2d.setPaint(Color.blue);
        g2d.draw(light);
        g2d.fill(light);
        
         //STOPLIGHT 2
        light.moveTo(625, 625);
        light.lineTo(725, 625);
        light.lineTo(725, 675);
        light.lineTo(625, 675);
        
        g2d.setPaint(Color.blue);
        g2d.draw(light);
        g2d.fill(light);
        
         //STOPLIGHT 2
        light.moveTo(375, 625);
        light.lineTo(325, 625);
        light.lineTo(325, 725);
        light.lineTo(375, 725);
        
        g2d.setPaint(Color.blue);
        g2d.draw(light);
        g2d.fill(light);
        
        //CROSS-ROAD
        road.moveTo(0,375);
        road.lineTo(375, 375); //corner 
        road.lineTo(375, 0);
        road.lineTo(625, 0);
        road.lineTo(625, 375); //corner 
        road.lineTo(1000, 375);
        road.lineTo(1000,625);
        road.lineTo(625, 625); //corner 
        road.lineTo(625,1000);
        road.lineTo(375,1000);
        road.lineTo(375,625); //corner 
        road.lineTo(0,625);
      
        g2d.setPaint(Color.gray);
        g2d.draw(road);
        g2d.fill(road);
        
        //INTERSECTION
        inter.moveTo(375, 375);
        inter.lineTo(625, 625);
        
        g2d.setPaint(Color.white);
        g2d.draw(inter);
        g2d.fill(inter);
        
        inter.moveTo(625, 375);
        inter.lineTo(375, 625);
        
        g2d.setPaint(Color.white);
        g2d.draw(inter);
        g2d.fill(inter);
        
       //road sign
       g2d.drawLine(0, 500, 10, 10);
           
        */
       
    }       
        public void sustain(long t){
        long finish = (new Date()).getTime()+t;
        while((new Date().getTime()<finish));
    }
    
    
    public static void main(String[] args) {
        FourWayTraffic_TOBIAS s = new FourWayTraffic_TOBIAS();
        s.setTitle("4waytraffic");
        s.setBackground(Color.white);
        s.setSize(950,681);
        s.setVisible(true);
    }

            

}