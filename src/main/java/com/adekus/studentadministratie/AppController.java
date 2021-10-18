package com.adekus.studentadministratie;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adekus.studentadministratie.domain.*;
import com.adekus.studentadministratie.services.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AppController {
	@Autowired
	private PersoonService persoonService;
	@Autowired
	private GeslachtService geslachtService;
	@Autowired
	private BurgelijkeStaatservice burgelijkeStaatservice;
	@Autowired
	private NationaliteitService nationaliteitService;
	@Autowired
	private GeboorteLandService geboorteLandService;
	@Autowired
	private VooropleidingService vooropleidingService;
	@Autowired
	private BevolkingsGroepService bevolkingsGroepService;
	@Autowired
	private DistrictService districtService;
	@Autowired
	private StraatService straatService;
	@Autowired
	private FaculteitService faculteitService;
	@Autowired
	private StudierichtingService studierichtingService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private CollegejaarService collegejaarService;
	@Autowired
	private MaxNummersService maxNummersService;

	@RequestMapping("/")
	public String viewHomePagePersoon(Model model) {
		List<Persoon> listPersoon = persoonService.listAll();
		List<Burgelijkestaat> burgelijkeStaatList = burgelijkeStaatservice.listAll();
		List<Nationaliteit> nationaliteitList = nationaliteitService.listAll();
		List<Geboorteland> geboorteLandList = geboorteLandService.listAll();
		List<Vooropleiding> vooropleidingList = vooropleidingService.listAll();
		List<Bevolkingsroep> bevolkingsGroepList = bevolkingsGroepService.listAll();
		List<District> districtList = districtService.listAll();
		List<Straat> straatList = straatService.listAll();
		model.addAttribute("listPersoon", listPersoon);
		model.addAttribute("burgelijkeStaatList",burgelijkeStaatList);
		model.addAttribute("nationaliteitList",nationaliteitList);
		model.addAttribute(geboorteLandList);
		model.addAttribute(vooropleidingList);
		model.addAttribute(bevolkingsGroepList);
		model.addAttribute(districtList);
		model.addAttribute(straatList);
		return "index";
	}

	@RequestMapping("/new")
	public String showNewPersoonPage(Model model) {
		Persoon persoon = new Persoon();
		List<Geslacht> geslachtList = geslachtService.listAll();
		List<Burgelijkestaat> burgelijkeStaatList = burgelijkeStaatservice.listAll();
		List<Nationaliteit> nationaliteitList = nationaliteitService.listAll();
		List<Geboorteland> geboorteLandList = geboorteLandService.listAll();
		List<Vooropleiding> vooropleidingList = vooropleidingService.listAll();
		List<Bevolkingsroep> bevolkingsGroepList = bevolkingsGroepService.listAll();
		List<District> districtList = districtService.listAll();
		List<Straat> straatList = straatService.listAll();
		model.addAttribute("persoon", persoon);
		model.addAttribute("geslachtList",geslachtList);
		model.addAttribute("burgelijkeStaatList",burgelijkeStaatList);
		model.addAttribute("nationaliteitList",nationaliteitList);
		model.addAttribute(vooropleidingList);
		model.addAttribute(geboorteLandList);
		model.addAttribute(bevolkingsGroepList);
		model.addAttribute(districtList);
		model.addAttribute(straatList);
		return "new_persoon";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePersoon(@ModelAttribute("persoon") Persoon persoon) {
		persoonService.save(persoon);
		//System.out.println("***********************************************************");
		//System.out.println(persoon);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditPersoonPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_persoon");
		Persoon persoon = persoonService.get(id);
		List<Geslacht> geslachtList = geslachtService.listAll();
		List<Burgelijkestaat> burgelijkeStaatList = burgelijkeStaatservice.listAll();
		List<Nationaliteit> nationaliteitList = nationaliteitService.listAll();
		List<Geboorteland> geboorteLandList = geboorteLandService.listAll();
		List<Vooropleiding> vooropleidingList = vooropleidingService.listAll();
		List<Bevolkingsroep> bevolkingsGroepList = bevolkingsGroepService.listAll();
		List<District> districtList = districtService.listAll();
		List<Straat> straatList = straatService.listAll();
		mav.addObject("persoon", persoon);
		mav.addObject("geslachtList",geslachtList);
		mav.addObject(burgelijkeStaatList);
		mav.addObject(nationaliteitList);
		mav.addObject(geboorteLandList);
		mav.addObject(vooropleidingList);
		mav.addObject(bevolkingsGroepList);
		mav.addObject(districtList);
		mav.addObject(straatList);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deletePersoon(@PathVariable(name = "id") long id) {
		persoonService.delete(id);
		return "redirect:/";
	}

	@RequestMapping("/view_geboorteland")
	public String viewGeboortelandPage(Model model){
		List<Geboorteland> geboorteLandList = geboorteLandService.listAll();
		model.addAttribute(geboorteLandList);
		return "view_geboorteland";
	}

	@RequestMapping("/add_geboorteland")
	public String addGeboortelandPage(Model model){
		Geboorteland geboorteLand = new Geboorteland();
		model.addAttribute(geboorteLand);
		return "new_geboorteland";
	}

	@RequestMapping(value = "/save_geboorteland", method = RequestMethod.POST)
	public String saveGeboorteland(@ModelAttribute("geboorteland") Geboorteland geboorteLand) {
		geboorteLandService.save(geboorteLand);
		return "redirect:/view_geboorteland";
	}

	@RequestMapping("/edit_geboorteland/{id}")
	public ModelAndView editGeboortelandPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_geboorteland");
		Geboorteland geboorteLand = geboorteLandService.get(id);
		mav.addObject(geboorteLand);
		return mav;
	}

	@RequestMapping("/delete_geboorteland/{id}")
	public String deleteGeboorteland(@PathVariable(name = "id") int id) {
		geboorteLandService.delete(id);
		return "redirect:/view_geboorteland";
	}


	@RequestMapping("/view_bevolkingsgroep")
	public String viewBevolkingsgroepPage(Model model){
		List<Bevolkingsroep> bevolkingsGroepList = bevolkingsGroepService.listAll();
		model.addAttribute(bevolkingsGroepList);
		return "view_bevolkingsgroep";
	}

	@RequestMapping("/add_bevolkingsgroep")
	public String addBevolkingsgroepPage(Model model){
		Bevolkingsroep bevolkingsGroep = new Bevolkingsroep();
		model.addAttribute(bevolkingsGroep);
		return "new_bevolkingsgroep";
	}

	@RequestMapping(value = "/save_bevolkingsgroep", method = RequestMethod.POST)
	public String saveBevolkingsgroep(@ModelAttribute("bevolkingsgroep") Bevolkingsroep bevolkingsGroep) {
		bevolkingsGroepService.save(bevolkingsGroep);
		return "redirect:/view_bevolkingsgroep";
	}

	@RequestMapping("/edit_bevolkingsgroep/{id}")
	public ModelAndView editBevolkingsgroepPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_bevolkingsgroep");
		Bevolkingsroep bevolkingsGroep = bevolkingsGroepService.get(id);
		mav.addObject(bevolkingsGroep);
		return mav;
	}

	@RequestMapping("/delete_bevolkingsgroep/{id}")
	public String deleteBevolkingsgroep(@PathVariable(name = "id") int id) {
		bevolkingsGroepService.delete(id);
		return "redirect:/view_bevolkingsgroep";
	}

	@RequestMapping("/view_burgelijkestaat")
	public String viewBurgelijkeStaatPage(Model model){
		List<Burgelijkestaat> burgelijkeStaatList = burgelijkeStaatservice.listAll();
		model.addAttribute(burgelijkeStaatList);
		return "view_burgelijkestaat";
	}

	@RequestMapping("/add_burgelijkestaat")
	public String addBurgelijkeStaatPage(Model model){
		Burgelijkestaat burgelijkeStaat = new Burgelijkestaat();
		model.addAttribute(burgelijkeStaat);
		return "new_burgelijkestaat";
	}

	@RequestMapping(value = "/save_burgelijkestaat", method = RequestMethod.POST)
	public String saveBurgelijkeStaat(@ModelAttribute("burgelijkestaat") Burgelijkestaat burgelijkeStaat) {
		burgelijkeStaatservice.save(burgelijkeStaat);
		return "redirect:/view_burgelijkestaat";
	}

	@RequestMapping("/edit_burgelijkestaat/{id}")
	public ModelAndView editBurgelijkeStaatPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_burgelijkestaat");
		Burgelijkestaat burgelijkeStaat = burgelijkeStaatservice.get(id);
		mav.addObject(burgelijkeStaat);
		return mav;
	}

	@RequestMapping("/delete_burgelijkestaat/{id}")
	public String deleteBurgelijkeStaat(@PathVariable(name = "id") int id) {
		burgelijkeStaatservice.delete(id);
		return "redirect:/view_burgelijkestaat";
	}

	@RequestMapping("/view_district")
	public String viewDistrictPage(Model model){
		List<District> districtList = districtService.listAll();
		model.addAttribute(districtList);
		return "view_district";
	}

	@RequestMapping("/add_district")
	public String addDistrictPage(Model model){
		District district = new District();
		model.addAttribute(district);
		return "new_district";
	}

	@RequestMapping(value = "/save_district", method = RequestMethod.POST)
	public String saveDistrict(@ModelAttribute("district") District district) {
		districtService.save(district);
		return "redirect:/view_district";
	}

	@RequestMapping("/edit_district/{id}")
	public ModelAndView editDistrictPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_district");
		District district = districtService.get(id);
		mav.addObject(district);
		return mav;
	}

	@RequestMapping("/delete_district/{id}")
	public String deleteDistrict(@PathVariable(name = "id") int id) {
		districtService.delete(id);
		return "redirect:/view_district";
	}

	@RequestMapping("/view_nationaliteit")
	public String viewNationaliteitPage(Model model){
		List<Nationaliteit> nationaliteitList = nationaliteitService.listAll();
		model.addAttribute(nationaliteitList);
		return "view_nationaliteit";
	}

	@RequestMapping("/add_nationaliteit")
	public String addNationaliteitPage(Model model){
		Nationaliteit nationaliteit = new Nationaliteit();
		model.addAttribute(nationaliteit);
		return "new_nationaliteit";
	}

	@RequestMapping(value = "/save_nationaliteit", method = RequestMethod.POST)
	public String saveNationaliteit(@ModelAttribute("nationaliteit") Nationaliteit nationaliteit) {
		nationaliteitService.save(nationaliteit);
		return "redirect:/view_nationaliteit";
	}

	@RequestMapping("/edit_nationaliteit/{id}")
	public ModelAndView editNationaliteitPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_nationaliteit");
		Nationaliteit nationaliteit = nationaliteitService.get(id);
		mav.addObject(nationaliteit);
		return mav;
	}

	@RequestMapping("/delete_nationaliteit/{id}")
	public String deleteNationaliteit(@PathVariable(name = "id") int id) {
		nationaliteitService.delete(id);
		return "redirect:/view_nationaliteit";
	}

	@RequestMapping("/view_straat")
	public String viewStraatPage(Model model){
		List<Straat> straatList = straatService.listAll();
		model.addAttribute(straatList);
		return "view_straat";
	}

	@RequestMapping("/add_straat")
	public String addStraatPage(Model model){
		Straat straat = new Straat();
		model.addAttribute(straat);
		return "new_straat";
	}

	@RequestMapping(value = "/save_straat", method = RequestMethod.POST)
	public String saveStraat(@ModelAttribute("straat") Straat straat) {
		straatService.save(straat);
		return "redirect:/view_straat";
	}

	@RequestMapping("/edit_straat/{id}")
	public ModelAndView editStraatPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_straat");
		Straat straat = straatService.get(id);
		mav.addObject(straat);
		return mav;
	}

	@RequestMapping("/delete_straat/{id}")
	public String deleteStraat(@PathVariable(name = "id") int id) {
		straatService.delete(id);
		return "redirect:/view_straat";
	}

	@RequestMapping("/view_faculteit")
	public String viewFaculteitPage(Model model){
		List<Faculteit> faculteitList = faculteitService.listAll();
		model.addAttribute(faculteitList);
		return "view_faculteit";
	}

	@RequestMapping("/add_faculteit")
	public String addFaculteitPage(Model model){
		Faculteit faculteit = new Faculteit();
		model.addAttribute(faculteit);
		return "new_faculteit";
	}

	@RequestMapping(value = "/save_faculteit", method = RequestMethod.POST)
	public String saveFaculteit(@ModelAttribute("faculteit") Faculteit faculteit) {
		faculteitService.save(faculteit);
		return "redirect:/view_faculteit";
	}

	@RequestMapping("/edit_faculteit/{id}")
	public ModelAndView editFaculteitPage(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("edit_faculteit");
		Faculteit faculteit = faculteitService.get(id);
		mav.addObject(faculteit);
		return mav;
	}

	@RequestMapping("/delete_faculteit/{id}")
	public String deleteFaculteit(@PathVariable(name = "id") String id) {
		faculteitService.delete(id);
		return "redirect:/view_faculteit";
	}

	@RequestMapping("/view_studierichting")
	public String viewStudierichtingPage(Model model){
		List<Studierichting> studierichtingList = studierichtingService.listAll();
		List<Faculteit> faculteitList = faculteitService.listAll();
		model.addAttribute(studierichtingList);
		model.addAttribute(faculteitList);
		return "view_studierichting";
	}

	@RequestMapping("/add_studierichting")
	public String addStudierichtingPage(Model model){
		Studierichting studierichting = new Studierichting();
		List<Faculteit> faculteitList = faculteitService.listAll();
		model.addAttribute(studierichting);
		model.addAttribute(faculteitList);
		return "new_studierichting";
	}

	@RequestMapping(value = "/save_studierichting", method = RequestMethod.POST)
	public String saveStudierichting(@ModelAttribute("studierichting") Studierichting studierichting) {
		studierichtingService.save(studierichting);
		return "redirect:/view_studierichting";
	}

	@RequestMapping("/edit_studierichting/{id}")
	public ModelAndView editStudierichtingPage(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("edit_studierichting");
		Studierichting studierichting = studierichtingService.get(id);
		List<Faculteit> faculteitList = faculteitService.listAll();
		mav.addObject(studierichting);
		mav.addObject(faculteitList);
		return mav;
	}

	@RequestMapping("/delete_studierichting/{id}")
	public String deleteStudierichting(@PathVariable(name = "id") String id) {
		studierichtingService.delete(id);
		return "redirect:/view_studierichting";
	}

	@RequestMapping("/view_student")
	public String viewStudentPage(Model model){
		List<Student> studentList = studentService.listAll();
		List<Persoon> persoonList = persoonService.listAll();
		List<Studierichting> studierichtingList = studierichtingService.listAll();
		List<Faculteit> faculteitList = faculteitService.listAll();
		model.addAttribute(studentList);
		model.addAttribute(persoonList);
		model.addAttribute(studierichtingList);
		model.addAttribute(faculteitList);
		return "view_student";
	}

	@RequestMapping("/add_student")
	public String addStudentPage(Model model,@RequestParam(required = false) String prmStudierichting,
								 @RequestParam(required = false) Long prmCollegejaar){
		Student student = new Student();
		List<Persoon> persoonList = persoonService.listAll();
		List<Studierichting> studierichtingList = studierichtingService.listAll();
		List<Collegejaar> collegejaarList = collegejaarService.listAll();
		Long maxnummer = maxNummersService.findMaxByCollegejaarAndStudierichting(prmStudierichting,prmCollegejaar);
		if(maxnummer==null||maxnummer==0)
			maxnummer=Long.valueOf(1000);
		else
			maxnummer++;
		maxNummersService.insertNewMaxNummer(prmCollegejaar,prmStudierichting,maxnummer);
		model.addAttribute(student);
		model.addAttribute(persoonList);
		model.addAttribute(studierichtingList);
		model.addAttribute(collegejaarList);
		//System.out.println(collegejaar);
		//System.out.println("Studierichting: "+studierichting);
		return "new_student";
	}

	@RequestMapping(value = "/save_student", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student,
							  @RequestParam(required = false) Studierichting studierichting,
							  @RequestParam(required = false) Long collegejaar,
							  @RequestParam(required = false) String studentnr) {
		String richting = studierichting.getId();
		Long jaar=collegejaar;//.getJaar();
		Long maxNummer = maxNummersService.findMaxByCollegejaarAndStudierichting(richting,jaar);
		System.out.println("Collegejaar: "+jaar);
		System.out.println("Studierichting: "+richting);
		System.out.println("Maxnummer: "+maxNummer);
		System.out.println("Studentnr: "+studentnr);
		System.out.println("**********************************");
		studentService.save(student);
		return "redirect:/view_student";
	}

	@RequestMapping("/edit_student/{id}")
	public ModelAndView editStudentPage(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("edit_student");
		Student student = studentService.get(id);
		//Persoon persoon = persoonService.get(student.getPersoonId());
		List<Collegejaar> collegejaarList = collegejaarService.listAll();
		//System.out.println("Naam: "+persoon.getNaam());
		List<Studierichting> studierichtingList = studierichtingService.listAll();
		mav.addObject(student);
		mav.addObject(studierichtingList);
		//mav.addObject(persoon);
		mav.addObject(collegejaarList);
		return mav;
	}

	@RequestMapping("/delete_student/{id}")
	public String deleteStudent(@PathVariable(name = "id") String id) {
		studentService.delete(id);
		return "redirect:/view_student";
	}
	@RequestMapping("/view_collegejaar")
	public String viewCollegejaarPage(Model model){
		List<Collegejaar> collegejaarList = collegejaarService.listAll();
		model.addAttribute(collegejaarList);
		return "view_collegejaar";
	}
/*
	@RequestMapping("/add_collegejaar")
	public String addCollegejaarPage(Model model){
		Collegejaar collegejaar = new Collegejaar();
		model.addAttribute(collegejaar);
		return "new_collegejaar";
	}
*/
	@RequestMapping("/add_collegejaar")
	public String addCollegejaarPage(Model model){
		Collegejaar collegejaar = new Collegejaar();
		model.addAttribute(collegejaar);
		return "new_collegejaar";
	}

	@RequestMapping(value = "/save_collegejaar", method = RequestMethod.POST)
	public String saveCollegejaar(@ModelAttribute("collegejaar") Collegejaar collegejaar) {
		collegejaarService.save(collegejaar);
		return "redirect:/view_collegejaar";
	}

	@RequestMapping("/edit_collegejaar/{id}")
	public ModelAndView editCollegejaarPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_collegejaar");
		Collegejaar collegejaar = collegejaarService.get(id);
		mav.addObject(collegejaar);
		return mav;
	}

	@RequestMapping("/delete_collegejaar/{id}")
	public String deleteCollegejaar(@PathVariable(name = "id") int id) {
		collegejaarService.delete(id);
		return "redirect:/view_collegejaar";
	}

	@GetMapping("/student_report")
	public String generateStudentReport() {
		return studentService.generateStudentReport();
	}

	@RequestMapping(value = "/helloReport", method = RequestMethod.GET)
	@ResponseBody
	public void getRpt1(HttpServletResponse response) throws JRException, IOException {
		InputStream jasperStream = this.getClass().getResourceAsStream("/templates/reports/student-rpt.jrxml");
		Map<String,Object> params = new HashMap<>();
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

		System.out.println("Report filled with data ...");
		// Export the report to a PDF file
		JasperExportManager.exportReportToPdfFile(jasperPrint, /*reportPath +*/ "student-rpt.pdf");
		System.out.println("Done exporting report to pdf file");
	}
}
