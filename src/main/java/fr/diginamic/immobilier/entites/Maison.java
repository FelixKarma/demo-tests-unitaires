package fr.diginamic.immobilier.entites;

public class Maison {

	private Piece[] pieces;

	public Maison(){
		pieces = new Piece[0];
	}

	public void ajouterPiece(Piece nvPiece) {
		if (nvPiece == null) {
			return;
		};

		Piece[] newTab = new Piece[pieces.length + 1];
		System.arraycopy(pieces, 0, newTab, 0, pieces.length);
		newTab[newTab.length - 1] = nvPiece;
		this.pieces = newTab;
	}

	public int nbPieces() {
		return pieces.length;
	}

	public double superficieEtage(int choixEtage) {
		double superficieEtage = 0;
		for (Piece piece : pieces) {
			if (piece != null && choixEtage == piece.getNumEtage()) {
				superficieEtage += piece.getSuperficie();
			}
		}
		return superficieEtage;
	}

	public double superficieTypePiece(String typePiece) {
		double superficie = 0;
		for (Piece piece : pieces) {
			if (piece != null && typePiece != null && typePiece.equals(piece.getType())) {
				superficie += piece.getSuperficie();
			}
		}
		return superficie;
	}

	public double calculerSurface() {
		double superficieTot = 0;
		for (Piece piece : pieces) {
			if (piece != null) {
				superficieTot += piece.getSuperficie();
			}
		}
		return superficieTot;
	}

	public Piece[] getPieces() {
		return pieces;
	}
}
