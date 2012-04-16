import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Pawn extends ChessPiece {

	ImageIcon image;
	
	ImageIcon newImage1;
	ImageIcon newImage2;
	ImageIcon newImage3;
	ImageIcon newImage4;
	
	int turn = 0;

	
	public Pawn(int x, int y,String color) {
		super(x, y);
	
		pieceType = "Pawn";

		
		if (color.equals("Black")){
			this.image = new ImageIcon(System.getProperty("user.dir") + "/images/PawnBlack.png");
			this.pieceColor = "Black";
		}
		if (color.equals("White")){
	    	this.image = new ImageIcon(System.getProperty("user.dir") + "/images/PawnWhite.png");
	    	this.pieceColor = "White";
		}
        		
		
        this.imglabel = new JLabel(this.image);
		
        imglabel.putClientProperty ("chesspiece", this);
	}

	@Override
	public boolean validateMove(Location destinationPosition) {
		
		int desPosX  = destinationPosition.getLoc()[0];
		int desPosY  = destinationPosition.getLoc()[1];
		
		int curPosX = this.location.getLoc()[0];
		int curPosY = this.location.getLoc()[1];
		
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		
		this.location.setLoc(desPosX,  desPosY); // Temporarily update the location of piece 
		
		for ( int i=0; i< chessBoard.blackPieces.size() ; i++){
			
			if( chessBoard.blackPieces.get(i).pieceType.equals("Knight") && this.pieceColor.equals("White") ) {
				System.out.println("knight check begin");
				if ( ( (Knight)chessBoard.blackPieces.get(i) ).hasCheckOnOpposingKing(chessBoard.whiteKingLoc) ){
					System.out.println("check");
					this.location.setLoc(curPosX,  curPosY);
					if ( this.canKill(destinationPosition) ){
						this. deletePiece(destinationPosition);
						return true;
					}
					return false;
				}
			}
		
			else if( chessBoard.blackPieces.get(i).pieceType.equals("Queen") && this.pieceColor.equals("White") ) {
				System.out.println("Queen check begin");
				if ( ( (Queen)chessBoard.blackPieces.get(i) ).hasCheckOnOpposingKing(chessBoard.whiteKingLoc) ){
					System.out.println("check");
					this.location.setLoc(curPosX,  curPosY);
					if ( this.canKill(destinationPosition) ){
						this. deletePiece(destinationPosition);
						return true;
					}
					return false;
				}
			}
			
			else if( chessBoard.blackPieces.get(i).pieceType.equals("Pawn") && this.pieceColor.equals("White") ) {
				System.out.println("pawn check begin");
				if ( ( (Pawn)chessBoard.blackPieces.get(i) ).hasCheckOnOpposingKing(chessBoard.whiteKingLoc) ){
					System.out.println("check");
					this.location.setLoc(curPosX,  curPosY);
					if ( this.canKill(destinationPosition) ){
						this. deletePiece(destinationPosition);
						return true;
					}
					return false;
				}
			}
			
			else if( chessBoard.blackPieces.get(i).pieceType.equals("Rook") && this.pieceColor.equals("White") ) {
				System.out.println("rook check begin");
				if ( ( (Rook)chessBoard.blackPieces.get(i) ).hasCheckOnOpposingKing(chessBoard.whiteKingLoc) ){
					System.out.println("check");
					this.location.setLoc(curPosX,  curPosY);
					if ( this.canKill(destinationPosition) ){
						this. deletePiece(destinationPosition);
						return true;
					}
					return false;
				}
			}
			
			else if( chessBoard.blackPieces.get(i).pieceType.equals("Bishop") && this.pieceColor.equals("White") ) {
				System.out.println("bishop check begin");
				if ( ( (Bishop)chessBoard.blackPieces.get(i) ).hasCheckOnOpposingKing(chessBoard.whiteKingLoc) ){
					System.out.println("check");
					this.location.setLoc(curPosX,  curPosY);
					if ( this.canKill(destinationPosition) ){
						this. deletePiece(destinationPosition);
						return true;
					}
					return false;
				}
			}
			
			else if( chessBoard.blackPieces.get(i).pieceType.equals("King") && this.pieceColor.equals("White") ) {
				System.out.println("bishop check begin");
				if ( ( (King)chessBoard.blackPieces.get(i) ).hasCheckOnOpposingKing(chessBoard.whiteKingLoc) ){
					System.out.println("check");
					this.location.setLoc(curPosX,  curPosY);
					if ( this.canKill(destinationPosition) ){
						this. deletePiece(destinationPosition);
						return true;
					}
					return false;
				}
			}
			
		}	

		
		for ( int i=0; i< chessBoard.whitePieces.size() ; i++){
			
			if( chessBoard.whitePieces.get(i).pieceType.equals("Knight") && this.pieceColor.equals("Black") ) {
				
				if ( ( (Knight)chessBoard.whitePieces.get(i) ).hasCheckOnOpposingKing(chessBoard.blackKingLoc) ){
					System.out.println("check");
					this.location.setLoc(curPosX,  curPosY);
					if ( this.canKill(destinationPosition) ){
						this. deletePiece(destinationPosition);
						return true;
					}
					return false;
				}
			}
			
			else if( chessBoard.whitePieces.get(i).pieceType.equals("Queen") && this.pieceColor.equals("Black") ) {
				
				if ( ( (Queen)chessBoard.whitePieces.get(i) ).hasCheckOnOpposingKing(chessBoard.blackKingLoc) ){
					System.out.println("check");
					this.location.setLoc(curPosX,  curPosY);
					
					if ( this.canKill(destinationPosition) ){
						this. deletePiece(destinationPosition);
						return true;
					}
					return false;
				}
			}
			
			
			else if( chessBoard.whitePieces.get(i).pieceType.equals("Pawn") && this.pieceColor.equals("Black") ) {
				
				if ( ( (Pawn)chessBoard.whitePieces.get(i) ).hasCheckOnOpposingKing(chessBoard.blackKingLoc) ){
					System.out.println("check");
					this.location.setLoc(curPosX,  curPosY);
					if ( this.canKill(destinationPosition) ){
						this. deletePiece(destinationPosition);
						return true;
					}
					return false;
				}
			}
			else if( chessBoard.whitePieces.get(i).pieceType.equals("Rook") && this.pieceColor.equals("Black") ) {
				
				if ( ( (Rook)chessBoard.whitePieces.get(i) ).hasCheckOnOpposingKing(chessBoard.blackKingLoc) ){
					System.out.println("check");
					this.location.setLoc(curPosX,  curPosY);
					if ( this.canKill(destinationPosition) ){
						this. deletePiece(destinationPosition);
						return true;
					}
					return false;
				}
			}
			
			else if( chessBoard.whitePieces.get(i).pieceType.equals("Bishop") && this.pieceColor.equals("Black") ) {
				
				if ( ( (Bishop)chessBoard.whitePieces.get(i) ).hasCheckOnOpposingKing(chessBoard.blackKingLoc) ){
					System.out.println("check");
					this.location.setLoc(curPosX,  curPosY);
					if ( this.canKill(destinationPosition) ){
						this. deletePiece(destinationPosition);
						return true;
					}
					return false;
				}
			}
			
			else if( chessBoard.whitePieces.get(i).pieceType.equals("King") && this.pieceColor.equals("Black") ) {
				System.out.println("bishop check begin");
				if ( ( (King)chessBoard.whitePieces.get(i) ).hasCheckOnOpposingKing(chessBoard.blackKingLoc) ){
					System.out.println("check");
					this.location.setLoc(curPosX,  curPosY);
					if ( this.canKill(destinationPosition) ){
						this. deletePiece(destinationPosition);
						return true;
					}
					return false;
				}
			}
		}
		
		
		this.location.setLoc(curPosX,  curPosY);

		
		if ( this.destinationColor(destinationPosition).equals("White") && this.pieceColor.equals("White") || 
				this.destinationColor(destinationPosition).equals("Black") && this.pieceColor.equals("Black")){
			return false;
		}
		
		if ( this.turn == 0 ){
				
			if ( this.isWhite()){
				if (desPosY == curPosY-1 && desPosX == curPosX || desPosY == curPosY-2 && desPosX == curPosX ){
					this.turn ++;
					return true;
				}
			}
			else if ( this.isBlack()){
				System.out.println("curPosY " + curPosY + " desPosY " +desPosY + "curPosX " + curPosX + " desPosX " +desPosX);
				if (desPosY == curPosY+1 && desPosX == curPosX || desPosY == curPosY+2 && desPosX == curPosX ){
					this.turn ++;
					return true;
				}
			}

		}
		else if ( this.turn > 0 ){
			
			if ( this.isWhite()){
				
				
				if (desPosY == curPosY-1 && desPosX == curPosX+1 || desPosY == curPosY-1 && desPosX == curPosX-1  ){
					
					if ( ! this.destinationCheck(destinationPosition)){
						return false;
					}
					
					this. deletePiece(destinationPosition);
					this.turn ++;
					return true;
				}
				
				else if (desPosY == curPosY-1 && desPosX == curPosX  ){
					//this. deletePiece(destinationPosition);
					if ( this.destinationCheck(destinationPosition)){
						return false;
					}
					this.turn ++;
					return true;
				}
			}
			else if ( this.isBlack()){
				
				if (desPosY == curPosY+1 && desPosX == curPosX+1 || desPosY == curPosY+1 && desPosX == curPosX-1  ){
					
					if ( ! this.destinationCheck(destinationPosition)){
						return false;
					}
					
					this. deletePiece(destinationPosition);
					this.turn ++;
					return true;
				}
				
				else if (desPosY == curPosY+1 && desPosX == curPosX  ){
						
						if ( this.destinationCheck(destinationPosition)){
							return false;
						}
						this.turn ++;
						return true;
					}
			}
			
			
			
			
		}
		return false;
	}

	
	public boolean validateCheck(Location destinationPosition) {
		
		int desPosX  = destinationPosition.getLoc()[0];
		int desPosY  = destinationPosition.getLoc()[1];
		
		int curPosX = this.location.getLoc()[0];
		int curPosY = this.location.getLoc()[1];
		
		if ( this.destinationColor(destinationPosition).equals("White") && this.pieceColor.equals("White") || 
				this.destinationColor(destinationPosition).equals("Black") && this.pieceColor.equals("Black")){
			return false;
		}

		if ( this.turn > -1 ){
			
			if ( this.isWhite()){
				
				
				if (desPosY == curPosY-1 && desPosX == curPosX+1 || desPosY == curPosY-1 && desPosX == curPosX-1  ){
					
					if ( ! this.destinationCheck(destinationPosition)){
						return false;
					}
					
					System.out.println("validateCheck check");
					return this.canKill(destinationPosition);
				}
				
				else if (desPosY == curPosY-1 && desPosX == curPosX  ){
					//this. deletePiece(destinationPosition);
					if ( this.destinationCheck(destinationPosition)){
						return false;
					}
					System.out.println("validateCheck check");
					return this.canKill(destinationPosition);
				}
				
			}
			else if ( this.isBlack()){
				
				if (desPosY == curPosY+1 && desPosX == curPosX+1 || desPosY == curPosY+1 && desPosX == curPosX-1  ){
					
					if ( ! this.destinationCheck(destinationPosition)){
						return false;
					}
					
					System.out.println("validateCheck check");
					return this.canKill(destinationPosition);
				}
				
				else if (desPosY == curPosY+1 && desPosX == curPosX  ){
					
					if ( this.destinationCheck(destinationPosition)){
						return false;
					}
					System.out.println("validateCheck check");
					return this.canKill(destinationPosition);
				}
			}
			
		}
		return false;
	}
	
	
	public boolean hasCheckOnOpposingKing(Location positionOfOpposingKing) {
		ChessBoard chessBoard = ChessBoard.getInstance();

		int KingX = positionOfOpposingKing.getLoc()[0];
		int KingY = positionOfOpposingKing.getLoc()[1];
		
		if ( this.validateCheck(positionOfOpposingKing)){
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	public ChessPiece kill(ChessPiece a) {
	
		ChessBoard chessBoard = ChessBoard.getInstance();
		
		if ( a.pieceType.equals("Pawn") && this.pieceColor.equals("White")){
			this.setDeActive();
			
  		  System.out.println("become queen w");
  		  int x = a.location.getLoc()[0];
  		  int y = a.location.getLoc()[1];
  		  
  		  //String nColor = a.pieceColor;
  		  
	  	  	  Queen queenW = new Queen (x,y,"White");
	  	  	  queenW.location.setLoc(x, y);

	  	  	  //chessBoard.whitePieces.add(queenW);
	  	  	  
	  	  	  return queenW;
	  	  	  
		}
		
		else if ( a.pieceType.equals("Pawn") && this.pieceColor.equals("Black")){
			this.setDeActive();
			
  		  System.out.println("become queen b");
  		  int x = a.location.getLoc()[0];
  		  int y = a.location.getLoc()[1];
  		  
  		  //String nColor = a.pieceColor;
  		  
	  	  	  Queen queenW = new Queen (x,y,"Black");
	  	  	  queenW.location.setLoc(x, y);
	  	  	  
	  	  	  //chessBoard.blackPieces.add(queenW);
	  	  	  
	  	  	  return queenW;
	  	  	  
		}
		return null;
	}
/*	
	public String whitePromotion(){
		
		JTextField userName = new JTextField();
		
		newImage1 = new ImageIcon(System.getProperty("user.dir") + "/images/QueenWhite.png");
		newImage2 = new ImageIcon(System.getProperty("user.dir") + "/images/BishopWhite.png");
		newImage3 = new ImageIcon(System.getProperty("user.dir") + "/images/KnightWhite.png");
		newImage4 = new ImageIcon(System.getProperty("user.dir") + "/images/RookWhite.png");
		
		JRadioButton knightR = new JRadioButton();
		JRadioButton queenR = new JRadioButton();
		JRadioButton bishopR = new JRadioButton();
		JRadioButton rookR = new JRadioButton();
		
		queenR.setSelected(true);
		
	    ButtonGroup group = new ButtonGroup();
	    group.add(knightR);
	    group.add(queenR);
	    group.add(bishopR);
	    group.add(rookR);
		
		Object[] array = {new JLabel("Select a piece:"),queenR,newImage1,bishopR,newImage2,knightR,newImage3,rookR,newImage4
		};
				
		int option = JOptionPane.showConfirmDialog(null, array, "Select",JOptionPane.YES_OPTION);
		
	    // User selected button 1
	    if (queenR.isSelected()) {return "Queen";}

	    // User selected button 2
	    if (bishopR.isSelected()) {return "Bishop"; }

	    // User selected button 3
	    if (knightR.isSelected()) {return "Knight";}

	    // User selected button 4
	    if (rookR.isSelected()) { return "Rook";}

	    return null;
		
		
	}
	*/
}
