import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Queen extends ChessPiece{
	ImageIcon image;

	public Queen(int x, int y,String color) {
		super(x, y);
	
		pieceType = "Queen";

		
		if (color.equals("Black")){
			this.image = new ImageIcon(System.getProperty("user.dir") + "/images/QueenBlack.png");
			this.pieceColor = "Black";
		}
		if (color.equals("White")){
	    	this.image = new ImageIcon(System.getProperty("user.dir") + "/images/QueenWhite.png");
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
				System.out.println("knight check begin");
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
				System.out.println("knight check begin");
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
				System.out.println("pawn check begin");
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
				System.out.println("rook check begin");
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
				System.out.println("bishop check begin");
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

			for ( int i=0;i<8;i++){
				
				//Bishop moves
				
				if (desPosY == curPosY+i && desPosX == curPosX-i  ){
					
					for(int j=0;j<i;j++){
						if( this.destinationCheck(new Location(curPosX-j,curPosY+j ))  ){
							return false;	
						}
					}
					
					
					this. deletePiece(destinationPosition);
					return true;
				}
				
				else if (desPosY == curPosY-i && desPosX == curPosX+i) {
					
					for(int j=0;j<i;j++){
						if( this.destinationCheck(new Location(curPosX+j,curPosY-j ))  ){
							return false;	
						}
					}
					
					
					this. deletePiece(destinationPosition);
					return true;
				}
				
				else if (desPosY == curPosY+i && desPosX == curPosX+i  ){
					
					for(int j=0;j<i;j++){
						if( this.destinationCheck(new Location(curPosX+j,curPosY+j ))  ){
							return false;	
						}
					}
					
					this. deletePiece(destinationPosition);
					return true;
				}
				
				else if ( desPosY == curPosY-i && desPosX == curPosX-i){
					
					for(int j=0;j<i;j++){
						if( this.destinationCheck(new Location(curPosX-j,curPosY-j ))  ){
							return false;	
						}
					}
					
					this. deletePiece(destinationPosition);
					return true;
					
				}
				// rook moves


				
				else if (desPosY == curPosY && desPosX == curPosX-i /*|| desPosY == curPosY && desPosX == curPosX+i*/ ){
					
					for(int j=1;j<i;j++){
						if( this.destinationCheck(new Location(curPosX-j,curPosY ))  ){
							return false;	
						}
					}
					
					
					this. deletePiece(destinationPosition);
					return true;
				}
				
				else if (desPosY == curPosY && desPosX == curPosX+i ){
					
					for(int j=1;j<i;j++){
						if( this.destinationCheck(new Location(curPosX+j,curPosY )) ||  this.destinationCheck(new Location(curPosX+j,curPosY ))  ){
							return false;	
						}
					}
					
					
					this. deletePiece(destinationPosition);
					return true;
				}
				
				else if (desPosY == curPosY+i && desPosX == curPosX /*|| desPosY == curPosY-i && desPosX == curPosX*/ ){
					
					for(int j=1;j<i;j++){
						if( this.destinationCheck(new Location(curPosX,curPosY+j )) ){
							return false;	
						}
				
					}
					this. deletePiece(destinationPosition);
					return true;
				}
				else if ( desPosY == curPosY-i && desPosX == curPosX ){
					
					for(int j=1;j<i;j++){
						if( this.destinationCheck(new Location(curPosX,curPosY-j )) ){
							return false;	
						}
					}						
					this. deletePiece(destinationPosition);
					return true;
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

			for ( int i=0;i<8;i++){
				
				//Bishop moves
				
				if (desPosY == curPosY+i && desPosX == curPosX-i  ){
					
					for(int j=0;j<i;j++){
						if( this.destinationCheck(new Location(curPosX-j,curPosY+j ))  ){
							return false;	
						}
					}
					
					
					System.out.println("validateCheck check");
					return this.canKill(destinationPosition);
					
				}
				
				else if (desPosY == curPosY-i && desPosX == curPosX+i) {
					
					for(int j=0;j<i;j++){
						if( this.destinationCheck(new Location(curPosX+j,curPosY-j ))  ){
							return false;	
						}
					}
					
					System.out.println("validateCheck check");
					return this.canKill(destinationPosition);
					
				}
				
				else if (desPosY == curPosY+i && desPosX == curPosX+i  ){
					
					for(int j=0;j<i;j++){
						if( this.destinationCheck(new Location(curPosX+j,curPosY+j ))  ){
							return false;	
						}
					}
					
					System.out.println("validateCheck check");
					return this.canKill(destinationPosition);
					
				}
				
				else if ( desPosY == curPosY-i && desPosX == curPosX-i){
					
					for(int j=0;j<i;j++){
						if( this.destinationCheck(new Location(curPosX-j,curPosY-j ))  ){
							return false;	
						}
					}
					
					System.out.println("validateCheck check");
					return this.canKill(destinationPosition);
					
					
				}
				// rook moves


				
				else if (desPosY == curPosY && desPosX == curPosX-i /*|| desPosY == curPosY && desPosX == curPosX+i*/ ){
					
					for(int j=1;j<i;j++){
						if( this.destinationCheck(new Location(curPosX-j,curPosY ))  ){
							return false;	
						}
					}
					
					
					System.out.println("validateCheck check");
					return this.canKill(destinationPosition);
					
				}
				
				else if (desPosY == curPosY && desPosX == curPosX+i ){
					
					for(int j=1;j<i;j++){
						if( this.destinationCheck(new Location(curPosX+j,curPosY )) ||  this.destinationCheck(new Location(curPosX+j,curPosY ))  ){
							return false;	
						}
					}
					
					
					System.out.println("validateCheck check");
					return this.canKill(destinationPosition);
					
				}
				
				else if (desPosY == curPosY+i && desPosX == curPosX /*|| desPosY == curPosY-i && desPosX == curPosX*/ ){
					
					for(int j=1;j<i;j++){
						if( this.destinationCheck(new Location(curPosX,curPosY+j )) ){
							return false;	
						}
				
					}
					System.out.println("validateCheck check");
					return this.canKill(destinationPosition);
					
				}
				else if ( desPosY == curPosY-i && desPosX == curPosX ){
					
					for(int j=1;j<i;j++){
						if( this.destinationCheck(new Location(curPosX,curPosY-j )) ){
							return false;	
						}
					}						
					System.out.println("validateCheck check");
					return this.canKill(destinationPosition);
					
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

}

