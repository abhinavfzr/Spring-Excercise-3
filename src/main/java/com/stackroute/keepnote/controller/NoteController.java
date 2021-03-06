package com.stackroute.keepnote.controller;


import com.stackroute.keepnote.model.Note;
import com.stackroute.keepnote.repository.NoteRepository;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*Annotate the class with @Controller annotation. @Controller annotation is used to mark
 * any POJO class as a controller so that Spring can recognize this class as a Controller
 * */
@Controller
public class NoteController {
	/*
	 * From the problem statement, we can understand that the application
	 * requires us to implement the following functionalities.
	 * 
	 * 1. display the list of existing notes from the collection. Each note 
	 *    should contain Note Id, title, content, status and created date.
	 * 2. Add a new note which should contain the note id, title, content and status.
	 * 3. Delete an existing note.
	 * 4. Update an existing note.
	 */
	ApplicationContext context;
	Note note;
	NoteRepository noteRepository;

	public NoteController()
	{
		 context= new ClassPathXmlApplicationContext("beans.xml");
		 note= (Note)context.getBean("note");
		noteRepository= (NoteRepository) context.getBean("noteRepository");
	}

	@RequestMapping("/")
	public String handler1(ModelMap map)
	{
		map.addAttribute(noteRepository.getAllNotes());
		return "index";
	}


	@RequestMapping("/saveNote")
	public String handler2(ModelMap map,@RequestParam("noteId") int  noteId,@RequestParam("noteContent") String  noteContent,@RequestParam("noteTitle") String  noteTitle,@RequestParam("noteStatus") String noteStatus)
	{
		Note note1= new Note();
		note1.setNoteId(noteId);
		note1.setNoteContent(noteContent);
		note1.setNoteTitle(noteTitle);
		note1.setNoteStatus(noteStatus);
		note1.setCreatedAt();
		noteRepository.addNote(note1);
		map.addAttribute(noteRepository.getAllNotes());
		return "index";
	}

	@RequestMapping("/deleteNote")
	public String handler3(ModelMap map,@RequestParam("noteId") int  noteId)
	{
		noteRepository.deleteNote(noteId);
		map.addAttribute(noteRepository.getAllNotes());
		return "redirect:/";
	}

	@RequestMapping("index")
	public String display(ModelMap map,@RequestParam("noteId") int  noteId,@RequestParam("noteContent") String  noteContent,@RequestParam("noteTitle") String  noteTitle,@RequestParam("noteStatus") String noteStatus)
	{
		Note note1= new Note();
		note1.setNoteId(noteId);
		note1.setNoteContent(noteContent);
		note1.setNoteTitle(noteTitle);
		note1.setNoteStatus(noteStatus);
		note1.setCreatedAt();
		noteRepository.addNote(note1);
		map.addAttribute("noteId",note1.getNoteId());
		map.addAttribute("noteContent",note1.getNoteContent());
		map.addAttribute("noteStatus",note1.getNoteStatus());
		map.addAttribute("noteTitle",note1.getNoteTitle());
		map.addAttribute("users",noteRepository.getAllNotes());
		return "index";
	}
	@RequestMapping("delete")
	public String delete(ModelMap map,@RequestParam("noteId") int  noteId)
	{
		noteRepository.deleteNote(noteId);
		map.addAttribute("users",noteRepository.getAllNotes());
		return "index";
	}
	/*
	 * Get the application context from resources/beans.xml file using ClassPathXmlApplicationContext() class.
	 * Retrieve the Note object from the context.
	 * Retrieve the NoteRepository object from the context.
	 */
	
	
	/*Define a handler method to read the existing notes by calling the getAllNotes() method 
	 * of the NoteRepository class and add it to the ModelMap which is an implementation of Map 
	 * for use when building model data for use with views. it should map to the default URL i.e. "/" */
	
	
	/*Define a handler method which will read the Note data from request parameters and
	 * save the note by calling the addNote() method of NoteRepository class. Please note 
	 * that the createdAt field should always be auto populated with system time and should not be accepted 
	 * from the user. Also, after saving the note, it should show the same along with existing 
	 * notes. Hence, reading notes has to be done here again and the retrieved notes object 
	 * should be sent back to the view using ModelMap.
	 * This handler method should map to the URL "/saveNote". 
	*/
	
	
	/* Define a handler method to delete an existing note by calling the deleteNote() method 
	 * of the NoteRepository class
	 * This handler method should map to the URL "/deleteNote" 
	*/
	
}