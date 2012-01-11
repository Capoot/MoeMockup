package moemockup.controller;

import java.io.IOException;

import moemockup.appLogic.Page;
import moemockup.model.Music;
import moemockup.persistence.MoeStorage;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/music/**")
@SessionAttributes({"music", "item"})
public class MusicController implements ApplicationContextAware {
	
	private static final Logger LOG = Logger.getLogger(MusicController.class);

	private ApplicationContext appContext;
	
	@RequestMapping("/list")
	public String listMusic(Model model) {
		MoeStorage storage = (MoeStorage)appContext.getBean("moeStorage");
		model.addAttribute("music", storage.getAllMusic());
		model.asMap().remove("item");
		return Page.MUSIC.getId();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveMusic(@RequestParam("file") MultipartFile file,
							@RequestParam(value = "ok", required = false) String ok,
							@ModelAttribute("item") Music music,
							Model model) {
		
		if(ok == null || ok.isEmpty()) {
			// operation aborted by user
			return "redirect:../music/list";
		}
		
		music.setFilename(file.getOriginalFilename());
		try {
			music.setRawData(file.getBytes());
		} catch (IOException e) {
			LOG.error("Error retrieving file data: " + e.getMessage());
			// TODO redirect error
			throw new RuntimeException("Error retrieving file data (501)");
		}
		MoeStorage storage = (MoeStorage)appContext.getBean("moeStorage");
		storage.save(music);
		
		return "redirect:../music/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteMusic(@PathVariable("id") long id) {
		MoeStorage storage = (MoeStorage)appContext.getBean("moeStorage");
		storage.remove(id);
		return "redirect:../../music/list";
	}
	
	@RequestMapping("/edit/{id}")
	public String editMusic(@PathVariable("id") long id, Model model) {
		MoeStorage storage = (MoeStorage)appContext.getBean("moeStorage");
		Music music = storage.loadMusic(id);
		model.addAttribute("item", music);
		return Page.MUSIC_FORM.getId();
	}
	
	@RequestMapping("/add")
	public String addMusic(Model model) {
		Music music = new Music();
		model.addAttribute("item", music);
		return Page.MUSIC_FORM.getId();
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}

}
