
public interface ChessPieceInterface {
	
	boolean validateMove(Location destinationPosition); //Before the player’s move is committed, it needs to validate if its correct per the rule of the game
	
	boolean makeMove(Location newLocation); //move the chess piece to the destination location, return false if an error occurs and the move is not made
	
	boolean hasCheckOnOpposingKing(Location positionOfOpposingKing); //Before the opposing player can complete his move, we need to check for this on all active chess pieces
	
	boolean isActive(); //to see if the piece has been killed
	
	boolean isWhite(); // to see if the player belongs to the white team
	
	boolean isBlack(); //to see if the player belongs to the black team
	
	ChessPiece kill(ChessPiece a); //The current object is being killed by ChessPiece a.
}
