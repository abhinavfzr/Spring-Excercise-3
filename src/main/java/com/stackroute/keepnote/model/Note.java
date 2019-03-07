package com.stackroute.keepnote.model;

import java.time.LocalDateTime;

/*
 * The class "Note" will be acting as the data model for the Note data in the ArrayList.
 */
public class Note {

	/*
	 * This class should have five fields (noteId, noteTitle, noteContent,
	 * noteStatus and createdAt). This class should also contain the getters and
	 * setters for the fields. The value of createdAt should not be accepted from
	 * the user but should be always initialized with the system date
	 */
	int noteId;
	String noteeTitle;
	String noteContent;
	String noteStatus;
	LocalDateTime createdAt;

	public Note() {
	}

	/* All the getters/setters definition should be implemented here */

	public int getNoteId() {
		return this.noteId;

	}

	public void setNoteId(int intid) {
		this.noteId=intid;

	}

	public String getNoteTitle() {
		return noteeTitle;
	}

	public void setNoteTitle(String string) {
		this.noteeTitle=string;

	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String string) {
		noteContent=string;

	}

	public String getNoteStatus() {
		return noteStatus;
	}

	public void setNoteStatus(String string) {
		this.noteStatus=string;

	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt() {
		this.createdAt.now();

	}

	/* Override the toString() method */
	@Override
	public String toString() {
		return "Note{" +
				"noteId=" + noteId +
				", noteeTitle='" + noteeTitle + '\'' +
				", noteContent='" + noteContent + '\'' +
				", noteStatus='" + noteStatus + '\'' +
				", createdAt=" + createdAt +
				'}';
	}

}