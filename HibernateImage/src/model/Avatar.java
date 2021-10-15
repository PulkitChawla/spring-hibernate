package model;

public class Avatar 
{
	private Integer avatarId;
	private byte[] image;

	public Avatar() {
	}

	public Avatar(byte[] image) {
		this.image = image;
	}

	public Integer getAvatarId() {
		return this.avatarId;
	}

	public void setAvatarId(Integer avatarId) {
		this.avatarId = avatarId;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
