import java.awt.*;
import java.awt.geom.*;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Clock_Analog extends Frame {

     public void paint (Graphics g)
     {
         
         int i_hour=0, i_min=0;     
	String stime = JOptionPane.showInputDialog("Input the time: ");
         String [] time = stime.split(":");
         i_hour = Integer.parseInt(time[0]);
         i_min = Integer.parseInt(time[1]);
         
         
          Graphics2D g2d = (Graphics2D) g;
       BasicStroke stroke = new BasicStroke(4.0f);
         BasicStroke stroke1 = new BasicStroke(10.0f);
       
       RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
       g2d.setRenderingHints(rh);

         Integer sec_clock = new Integer(50);
       Integer min_clock = new Integer(59);
       Integer hr_clock = new Integer(12);
        //face
            g2d.setStroke(stroke);
            g2d.setPaint(Color.WHITE);
            Ellipse2D.Double inner = new Ellipse2D.Double(270, 120, 460, 460);
            g2d.fill(inner);
            g2d.setPaint(Color.BLACK);
            g2d.draw(inner);

    //1-12
       g2d.setPaint(Color.BLACK);
            g.setFont(new Font("Gigi"/* Hadid <3*/, Font.PLAIN, 50));
            
                g2d.drawString("12",480,160);
                g2d.drawString("6",490,570);
                g2d.drawString("9",280,360);
                g2d.drawString("3",700,360);
                       
                g2d.drawString("1",600,200);
                g2d.drawString("2",670,280);
                g2d.drawString("4",670,440);
                g2d.drawString("5",600,530);
                g2d.drawString("7",360,530);
                g2d.drawString("8",300,440);
                g2d.drawString("11",360,200);
                g2d.drawString("10",300,280);
                
               

    //hands
       g2d.setStroke(stroke1);
            g2d.setPaint(Color.GREEN);
                Line2D.Double min = new Line2D.Double(25,360,25,235);
     
      
      g2d.setStroke(stroke1);
        g2d.setPaint(Color.GREEN);
            Line2D.Double hour = new Line2D.Double(25,360,25,285);
      
      g2d.setStroke(stroke1);
      AffineTransform rotateMinute = new AffineTransform();
        rotateMinute.translate(495,345);
        rotateMinute.rotate((i_min*(Math.PI/30)));
        rotateMinute.translate(-25,-370);
        g2d.setTransform(rotateMinute);
        g2d.setColor(Color.BLACK);
        g2d.draw(min);
        
         AffineTransform rotateHour = new AffineTransform();
        rotateHour.translate(495,345);
        rotateHour.rotate((i_hour*(Math.PI/6)));
        rotateHour.translate(-25,-370);
        g2d.setTransform(rotateHour);
        g2d.setColor(Color.BLACK);
        g2d.draw(hour);

        g2d.setFont(getFont().deriveFont(30f));
       String stamp="am";
       do{
               try{
                       Thread.sleep(1000);
               }catch(Exception e){
                       
               }
               if(sec_clock+1<60){
                       sec_clock++;
               }
               else{
                       min_clock++;
                       sec_clock=0;
               }
               if(min_clock>=60){
                       hr_clock++;
                       min_clock=0;
               }
               if(hr_clock>=13){
                       hr_clock=1;
                       if(stamp=="am"){
                               stamp="pm";
                       }
                       else{
                               stamp="am";
                       }
               }
       }while(true);
     }
     
    public static void main(String[] args) {
     Clock_Analog s = new Clock_Analog ();
       s.setTitle ("Analog Clock");
       s.setBackground(Color.white);
       s.setSize(1000,700);
       s.setVisible(true);
    }
}