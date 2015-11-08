import javax.swing.JFrame;

public class CalculatorDriver
{
   //-----------------------------------------------------------------
   //  Creates the main program frame.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Calculator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new CalculatorPanel());
      frame.setSize(250, 400);
      frame.pack();
      frame.setVisible(true);
   }
}
