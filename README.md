# Java Book Bot Pipeline

This project is a small Java-based text processing pipeline created for learning and practice purposes.

It reads a text file, analyzes its contents, and produces several statistical outputs in different formats.

---

## Features

- **Import and normalize text** from a file  
- **Count total words**  
- **Analyze character (letter) frequencies**  
- **Output results** to:  
  - CSV (comma-separated)  
  - SSV (semicolon-separated, Excel-friendly)  
  - JSON  
  - XML  

---

## Project Structure (High Level)

- **FileImporter** – loads and converts the input text  
- **WoerterZaehlen** – counts words in the text  
- **BuchstabenDIC** – builds a character frequency dictionary  
- **CSVOutput** – exports results to CSV/SSV  
- **JSON_XML_Converter** – converts CSV data to JSON and XML  
- **Javabookbotpipeline** – main entry point that orchestrates the pipeline  

---

## Output

- All generated files are written to the **project root directory** (next to `src`)  
- Improving configurability of output paths is a known future enhancement  

---

## Notes

- This project was originally implemented in Python and later ported to Java as an exercise  
- Some design decisions favor **clarity and learning** over optimal brevity  
  (e.g., custom dictionary structures instead of standard Maps)  

---

## Disclaimer

This project was written purely for **educational purposes** and is not intended for production use.

