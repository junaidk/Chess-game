import java.awt.BorderLayout;

import javax.swing.JLabel;


public class ChessPiece implements ChessPieceInterface {

	Location location ;
	String pieceColor;
	String pieceType;
	JLabel imglabel;
	
	JLabel selectedLabel;
	ChessPiece selectedPiece;
	
	int activeState = 1;
	
	public ChessPiece(){}
	
	public ChessPiece(int x, int y){
		location =new Location(x,y);
	}
	
	boolean destinationCheck (Location loc){
		ChessBoard chessBoard = ChessBoard.getInstance();

		int intX = loc.getLoc()[0];
		int intY = loc.getLoc()[1];
		
		for (int i =0 ; i < chessBoard.whitePieces.size() ; i++){
			if ( location.getLoc()[0] == intX && location.getLoc()[1] == intY){
				//System.out.println("false");
				return false;
			}			
			else if ( chessBoard.whitePieces.get(i).location.getLoc()[1] == intY && chessBoard.whitePieces.get(i).location.getLoc()[0] == intX  ){
				//System.out.println("w piece found on destination");
				return true;
			}
			
		}
		
		for (int i =0 ; i < chessBoard.blackPieces.size() ; i++){
			if ( location.getLoc()[0] == intX && location.getLoc()[1] == intY){
				//System.out.println("false");
				return false;
			}
			
			else if ( chessBoard.blackPieces.get(i).location.getLoc()[1] == intY && chessBoard.blackPieces.get(i).location.getLoc()[0] == intX  ){
				//System.out.println("b piece found on destination");
				return true;
			}
		}
		
		return false;
	}	
	

	public void deletePiece(Location destinationPosition){
		ChessBoard chessBoard = ChessBoard.getInstance();
		
		int desPosX  = destinationPosition.getLoc()[0];
		int desPosY  = destinationPosition.getLoc()[1];
		
		if ( this.destinationCheck(destinationPosition) ){
		//----------------
		      for(int z = 0; z < chessBoard.pnlChessCells[desPosY][desPosX].getComponentCount(); z++){
					
		    	  if (chessBoard.pnlChessCells[desPosY][desPosX].getComponentCount() != 0 ){
			    	  selectedLabel = (JLabel) chessBoard.pnlChessCells[desPosY][desPosX].getComponent(z);
			    	  selectedPiece = (ChessPiece) selectedLabel.getClientProperty("chesspiece");	
			    	  
			    	  if(this.pieceColor.equals("White") && selectedPiece.pieceColor.equals("Black") || this.pieceColor.equals("Black") && selectedPiece.pieceColor.equals("White")){ 
			    	  
				    	  chessBoard.pnlChessCells[desPosY][desPosX].remove(selectedPiece.imglabel);
				    	  selectedPiece.setDeActive();
				    	  
				    	  System.out.println("delete");
			    	  }
			      }
		      }	
		   
		      System.out.println(" out of delete");
		      //System.out.println(  selectedPiece.pieceType  );
		      chessBoard.pnlChessCells[desPosY][desPosX].repaint();
		//----------------

		}
	}
	
	public boolean canKill(Location destinationPosition){
		ChessBoard chessBoard = ChessBoard.getInstance();
		
		int desPosX  =  destinationPosition.getLoc()[0];
		int desPosY  = destinationPosition.getLoc()[1];
		System.out.println("can kill");
		
		if ( this.destinationCheck(destinationPosition) ){
		//----------------
		      for(int z = 0; z < chessBoard.pnlChessCells[desPosY][desPosX].getComponentCount(); z++){
					
		    	  if (chessBoard.pnlChessCells[desPosY][desPosX].getComponentCount() != 0 ){
			    	  selectedLabel = (JLabel) chessBoard.pnlChessCells[desPosY][desPosX].getComponent(z);
			    	  selectedPiece = (ChessPiece) selectedLabel.getClientProperty("chesspiece");	
			    	  System.out.println("Y " + selectedPiece.location.getLoc()[1] + " X " + selectedPiece.location.getLoc()[0]) ;
			    	  
			    	  if(this.pieceColor.equals("White") && selectedPiece.pieceColor.equals("Black") || this.pieceColor.equals("Black") && selectedPiece.pieceColor.equals("White")){ 

			    		  System.out.println("in can kill");
				    	  return true;
			    	  }
			      }
		      }	
		   
		      System.out.println(" out of can Kill");
		}
		return false;
	}
	
	
	
	
	
	@Override
	public boolean validateMove(Location destinationPosition) {
		// 
		return false;
	}

	
	String destinationColor (Location loc){
		ChessBoard chessBoard = ChessBoard.getInstance();

		int intX = loc.getLoc()[0];
		int intY = loc.getLoc()[1];
		
		for (int i =0 ; i < chessBoard.whitePieces.size() ; i++){
			//if ( location.getLoc()[0] == intX && location.getLoc()[1] == intY){
			//	//System.out.println("false");
			//	return false;
			//}			
			if ( chessBoard.whitePieces.get(i).location.getLoc()[1] == intY && chessBoard.whitePieces.get(i).location.getLoc()[0] == intX  ){
				//System.out.println("w piece found on destination");
				return "White";
			}
			
		}
		
		for (int i =0 ; i < chessBoard.blackPieces.size() ; i++){
			//if ( location.getLoc()[0] == intX && location.getLoc()[1] == intY){
			//	//System.out.println("false");
			//	return false;
			//}
			
			if ( chessBoard.blackPieces.get(i).location.getLoc()[1] == intY && chessBoard.blackPieces.get(i).location.getLoc()[0] == intX  ){
				//System.out.println("b piece found on destination");
				return "Black";
			}
		}
		return "nuetral";
	}	
	
	
	
	
		@Override
	public boolean makeMove(Location newLocation) {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		
		int intX = newLocation.getLoc()[0];
		int intY = newLocation.getLoc()[1];
		
		this.destinationCheck(chessBoard.clickedLoc);
		
		
		
		
		
		
		//this. canKill(newLocation);
		 //this condition decides the turn of player
		if ( chessBoard.playerTurn == 0 && this.pieceColor.equals("White") ){ 
		
		 if (  chessBoard.countClick == 0){
		      for(int z = 0; z < chessBoard.pnlChessCells[intY][intX].getComponentCount(); z++)
		
		            if(chessBoard.pnlChessCells[intY][intX].getComponent(z).getClass().toString().indexOf("JLabel") > -1)
		
		            {
			              chessBoard.countClick = 1;
			              imglabel = (JLabel) chessBoard.pnlChessCells[intY][intX].getComponent(z);
		                  //System.out.println(this.location.getLoc()[1]+" "+this.location.getLoc()[0] + "click " + chessBoard.countClick);
		                  
		                  chessBoard.drawBorder(intX, intY);
		            }
	                  
         }

         else if (  chessBoard.countClick == 1){
       	  Location loc = new Location(intX,intY);

       	  if ( this.validateMove(loc)) {
                 chessBoard.pnlChessCells[this.location.getLoc()[1]][this.location.getLoc()[0]].remove(this.imglabel);
 				
                 chessBoard.pnlChessCells[intY][intX].repaint();
                 
                 chessBoard.pnlChessCells[intY][intX].add(this.imglabel, BorderLayout.CENTER);
                 this.location.setLoc(intX, intY);
                 
                 chessBoard.playerTurn = 1;
       	  }
       	  chessBoard.countClick = 0;
       	  return true;
         }
		}
		if ( chessBoard.playerTurn == 1 && this.pieceColor.equals("Black") ){
			 if (  chessBoard.countClick == 0){
			      for(int z = 0; z < chessBoard.pnlChessCells[intY][intX].getComponentCount(); z++)
			
			            if(chessBoard.pnlChessCells[intY][intX].getComponent(z).getClass().toString().indexOf("JLabel") > -1)
			
			            {
				              chessBoard.countClick = 1;
				              imglabel = (JLabel) chessBoard.pnlChessCells[intY][intX].getComponent(z);
			                 // System.out.println(this.location.getLoc()[1]+" "+this.location.getLoc()[0] + "click " + chessBoard.countClick);			                  
			                  chessBoard.drawBorder(intX, intY);
			            }		               
	         }

	         else if (  chessBoard.countClick == 1){

	       	  //System.out.println("click " + chessBoard.countClick); 
	       	  Location loc = new Location(intX,intY);
	       	  //System.out.println("Y" + intY);
	       	  
	       	  if ( this.validateMove(loc)) {
	                 chessBoard.pnlChessCells[this.location.getLoc()[1]][this.location.getLoc()[0]].remove(this.imglabel);
	 				
	                 chessBoard.pnlChessCells[intY][intX].repaint();
	                 
	                 chessBoard.pnlChessCells[intY][intX].add(this.imglabel, BorderLayout.CENTER);
	                 this.location.setLoc(intX, intY);
	                 
	                 chessBoard.playerTurn = 0;
	       	  }
	       	  chessBoard.countClick = 0;
	       	  return true;
	         }
			}

		return false;
	}

	@Override
	public boolean hasCheckOnOpposingKing(Location positionOfOpposingKing) {
		ChessBoard chessBoard = ChessBoard.getInstance();

		int KingX = positionOfOpposingKing.getLoc()[0];
		int KingY = positionOfOpposingKing.getLoc()[1];
		
		//for ( int i=0; i< chessBoard.blackPieces.size() ; i++){
			
//			if( chessBoard.blackPieces.get(i).pieceType.equals("Rook") ) {
//				(Rook)chessBoard.blackPieces.get(i).			}
			
//		}
	
		return false;
	}
	
		
	@Override
	public boolean isActive() {
		if ( this.activeState == 1)
			return true;
		
		return false;
	}
	
	public void setDeActive(){
		this.activeState =0;
	}

	@Override
	public boolean isWhite() {
		if (this.pieceColor.equals("White"))
			return true;
		else 
			return false;
	}

	@Override
	public boolean isBlack() {
		if (this.pieceColor.equals("Black"))
			return true;
		else 
			return false;
		
	}
	@Override
	public ChessPiece kill(ChessPiece a) {
		// TODO Auto-generated method stub
		return null;
	}

}
