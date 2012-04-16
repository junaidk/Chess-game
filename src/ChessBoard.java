
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

public class ChessBoard extends JFrame implements MouseListener 

{    

	public int isSelect = 0;
	int countClick;
	int preX; // previous Jpanel x,y
	int preY;
	int playerTurn = 0;
	
	public Location whiteKingLoc ;
	public Location blackKingLoc ;
	
	public ArrayList<ChessPiece> blackPieces = new ArrayList<ChessPiece>();
	public ArrayList<ChessPiece> whitePieces = new ArrayList<ChessPiece>();;
	
	JLabel selectedLabel;
	ChessPiece selectedPiece;
	
	Location clickedLoc ;
	
	static ChessBoard board;
    
	
	public static void main(String[] args)

      {

            final ChessBoard chessBoard = ChessBoard.getInstance();  
            
            //System.out.println ( chessBoard.blackPieces.size() );

      }

      // the whole constructor is for setting up the UI of the form

	
	 public static ChessBoard getInstance(){
			if (board == null){
				board = new ChessBoard();
			}
			return board;
	 }
	
      private ChessBoard()

      {

            c = getContentPane();

            setBounds(100, 100, 470, 495);

            setBackground(new Color(204, 204, 204));

            setDefaultCloseOperation(EXIT_ON_CLOSE);

            setTitle("Chess");

            setResizable(false);

            c.setLayout(null);     

            pnlMain.setBounds(3, 3, 460, 460);

            pnlMain.setBackground(new Color(255, 255, 255));

            c.add(pnlMain);

            this.drawChessBoard();

            this.arrangeChessPieces();

            show();

      }
   // draw border method
      public void drawBorder(int x, int y){   

    	  isSelect = 1;
    	  preX = x;
    	  preY = y;
    	  
    	  pnlChessCells[y][x].setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.RED));
    	  isSelect = 1;
    	  
      }
      // delete border method
     public void deleteborder(int x, int y){

    	  pnlChessCells[y][x].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    	  isSelect = 0;
      }
      

      
      // This method captures the move on the chess board and then make

      // it happen, logically and physically; also, it sends the move to

      // the other client

      public void mouseClicked(MouseEvent e)

      {

                  Object source = e.getSource();

                  JPanel pnlTemp = (JPanel)source;         

                  this.deleteborder(preX, preY);

                  
                  int intX = (pnlTemp.getX()/57);

                  int intY = (pnlTemp.getY()/57);
   
                  clickedLoc = new Location(intX,intY);
                  
                  // if countClick is zero it means no piece is yet selected
                  if ( countClick == 0){

				      for(int z = 0; z < this.pnlChessCells[intY][intX].getComponentCount(); z++){
						
				    	  if (this.pnlChessCells[intY][intX].getComponentCount() != 0 ){
					    	  selectedLabel = (JLabel) this.pnlChessCells[intY][intX].getComponent(z);
					    	  selectedPiece = (ChessPiece) selectedLabel.getClientProperty("chesspiece");
 
					      }
				      }
			    	
                  }
                  
			      System.out.println(" countClick " +  countClick);
			      

                  
			      //selectedPiece.destinationCheck(clickedLoc);
			      selectedPiece.makeMove(clickedLoc);

			      if ( selectedPiece.pieceType.equals("Pawn") && selectedPiece.pieceColor.equals("White")){
			    	  if ( selectedPiece.location.getLoc()[1] == 0   ){  
			    		  
			    		  int x = selectedPiece.location.getLoc()[0];
			    		  int y = selectedPiece.location.getLoc()[1];
			    		  
			    		  Queen newQ = (Queen)selectedPiece.kill(selectedPiece);
			    		  whitePieces.add(newQ);
			    		  
			              this.pnlChessCells[y][x].remove(selectedPiece.imglabel);
			  				
			              this.pnlChessCells[y][x].repaint();
				  	  	  
				          this.pnlChessCells[y][x].add(newQ.imglabel, BorderLayout.CENTER);
			    		  
				    	  
			    	  }
			      }

					    if ( selectedPiece.pieceType.equals("Pawn") && selectedPiece.pieceColor.equals("Black")){
					    	  if ( selectedPiece.location.getLoc()[1] == 7   ){  
					    		  
					    		  int x = selectedPiece.location.getLoc()[0];
					    		  int y = selectedPiece.location.getLoc()[1];
					    		  
					    		  Queen newQ = (Queen)selectedPiece.kill(selectedPiece);
					    		  
					    		  blackPieces.add(newQ);
					    		  
					              this.pnlChessCells[y][x].remove(selectedPiece.imglabel);
					  				
					              this.pnlChessCells[y][x].repaint();
						  	  	  
						          this.pnlChessCells[y][x].add(newQ.imglabel, BorderLayout.CENTER);
					    		  
						    	  
					    	  }
					      }
			      

					    System.out.println(" black sizw " + blackPieces.size());
					    System.out.println("white size " + whitePieces.size());
      }    


      // Given the code of a piece as a string, this method instantiates an object of that piece

      //  with the right image inside it
      // and place it on the board
      
      private void getPieceObject(int x, int y,String strPieceName)

      {
	
	      if(strPieceName.equals("RB")){
	
	  	  	  Rook rookW = new Rook (x,y,"Black");
	  	  	  blackPieces.add(rookW);
	          rookW.location.setLoc(x, y);
	          this.pnlChessCells[y][x].add(rookW.imglabel, BorderLayout.CENTER);
	      }
	      else if(strPieceName.equals("BB")){
	
	  	  	  Bishop bishopB = new Bishop (x,y,"Black");
	  	  	  blackPieces.add(bishopB);
	  	  	  bishopB.location.setLoc(x, y);
	          this.pnlChessCells[y][x].add(bishopB.imglabel, BorderLayout.CENTER);
	
	      }
	      
	      else if(strPieceName.equals("NB")){
	
	    	  Knight knightB = new Knight (x,y,"Black");
	    	  blackPieces.add(knightB);
	    	  knightB.location.setLoc(x, y);
	          this.pnlChessCells[y][x].add(knightB.imglabel, BorderLayout.CENTER);
	
	      }
	      
	      else if(strPieceName.equals("QB")){
	
	  	  	  Queen queenB = new Queen (x,y,"Black");
	  	  	blackPieces.add(queenB);
	  	  	  queenB.location.setLoc(x, y);
	          this.pnlChessCells[y][x].add(queenB.imglabel, BorderLayout.CENTER);
	  	              
	      }
	      else if(strPieceName.equals("KB")){
	
	  	  	  King kingB = new King (x,y,"Black");
	  	  	  blackPieces.add(kingB);
	  	  	  kingB.location.setLoc(x, y);
	  	  	  blackKingLoc = new Location (x, y);
	          this.pnlChessCells[y][x].add(kingB.imglabel, BorderLayout.CENTER);
	  	       
	    	  
	      }
     
	      if(strPieceName.equals("PB")){
	
	    	  	Pawn pawnB = new Pawn (x,y,"Black");
	    	  	blackPieces.add(pawnB);
	            pawnB.location.setLoc(x, y);
	            this.pnlChessCells[y][x].add(pawnB.imglabel, BorderLayout.CENTER);
	            
	      }
	      
	      else if(strPieceName.equals("RW")){
	
	  	  	  Rook rookW = new Rook (x,y,"White");
	          rookW.location.setLoc(x, y);
	          whitePieces.add(rookW);
	          this.pnlChessCells[y][x].add(rookW.imglabel, BorderLayout.CENTER);
	      }
	
	      else if(strPieceName.equals("BW")){
	
	  	  	  Bishop bishopW = new Bishop (x,y,"White");
	  	  	  bishopW.location.setLoc(x, y);
	  	  	whitePieces.add(bishopW);
	  	  	  this.pnlChessCells[y][x].add(bishopW.imglabel, BorderLayout.CENTER);
	
	      }
	
	      else if(strPieceName.equals("NW")){

	    	  Knight knightW = new Knight (x,y,"White");
	  	  	  knightW.location.setLoc(x, y);
	  	  	whitePieces.add(knightW);
	          this.pnlChessCells[y][x].add(knightW.imglabel, BorderLayout.CENTER);
	
	      }
	      else if(strPieceName.equals("QW")){
	    	  
	  	  	  Queen queenW = new Queen (x,y,"White");
	  	  	  queenW.location.setLoc(x, y);
	  	  	whitePieces.add(queenW);
	          this.pnlChessCells[y][x].add(queenW.imglabel, BorderLayout.CENTER);
	          
	      }
	      else if(strPieceName.equals("KW")){
	
	  	  	  King kingW = new King (x,y,"White");
	  	  	  kingW.location.setLoc(x, y);
	  	  	whitePieces.add(kingW);
	  	  	whiteKingLoc = new Location (x, y);
	          this.pnlChessCells[y][x].add(kingW.imglabel, BorderLayout.CENTER);	  
	          
	      }
	      
	      else if(strPieceName.equals("PW")){
	
	    	  	Pawn pawnW = new Pawn (x,y,"White");
	            pawnW.location.setLoc(x, y);
	            whitePieces.add(pawnW);
	            this.pnlChessCells[y][x].add(pawnW.imglabel, BorderLayout.CENTER);	 
	            
	      }
	

      }
      
      
      // This method reads strChessBoard two-dimensional array of string
      
      // and places chess pieces at their right positions
      
      private void arrangeChessPieces()

      {                      

            for(int y = 0; y < 8; y++)       

            for(int x = 0; x < 8; x++) 

            {                
            	this.getPieceObject(x,y,strChessBoard[y][x]);
            }          

      }



      // This method draws chess board, i.e. black and white cells on the board

      private void drawChessBoard()

      {

            for (int y = 0; y < 8; y++)

                  for (int x = 0; x < 8; x++)

                  {

                        pnlChessCells[y][x] = new JPanel(new BorderLayout());

                        pnlChessCells[y][x].addMouseListener(this);

                        pnlMain.add(pnlChessCells[y][x]);

                        if (y % 2 == 0)

                              if (x % 2 != 0)

                                    pnlChessCells[y][x].setBackground(Color.DARK_GRAY);

                              else

                                    pnlChessCells[y][x].setBackground(Color.WHITE);

                        else

                              if (x % 2 == 0)

                                    pnlChessCells[y][x].setBackground(Color.DARK_GRAY);

                              else

                                    pnlChessCells[y][x].setBackground(Color.WHITE);

                  }

      }

      public void mouseEntered(MouseEvent e){} 

      public void mouseReleased(MouseEvent e){}

      public void mouseExited(MouseEvent e){}  

      public void mousePressed(MouseEvent e){}

      public JPanel[][] pnlChessCells = new JPanel[8][8];

      private JPanel pnlMain = new JPanel(new GridLayout(8,8));

      private String[][] strChessBoard = new String[][] { {"RB", "NB", "BB", "QB", "KB", "BB", "NB", "RB" }, {"PB", "PB", "PB", "PB", "PB", "PB", "PB", "PB"}, {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "}, {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "}, {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "}, {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "}, {"PW", "PW", "PW", "PW", "PW", "PW", "PW", "PW"}, {"RW", "NW", "BW", "QW", "KW", "BW", "NW", "RW"} };


      private Container c;

}