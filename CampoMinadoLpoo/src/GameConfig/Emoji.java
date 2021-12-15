package GameConfig;

public abstract class Emoji {
    private String unicBomb = "\uD83D\uDCA3";
    private String unicFlag = "\u2691";
    private String unicExplosion = "\uD83D\uDCA5";
	public String getUnicBomb() {
		return unicBomb;
	}
	public void setUnicBomb(String unicBomb) {
		this.unicBomb = unicBomb;
	}
	public String getUnicFlag() {
		return unicFlag;
	}
	public void setUnicFlag(String unicFlag) {
		this.unicFlag = unicFlag;
	}
	public String getUnicExplosion() {
		return unicExplosion;
	}
	public void setUnicExplosion(String unicExplosion) {
		this.unicExplosion = unicExplosion;
	}
    

}
