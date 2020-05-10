/**
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 */
public abstract class ProgrammingLanguage {
    private String compiler;
    private String extension;
    private String runConfig;
    private String flags;
    private String filename;

    public ProgrammingLanguage(String compiler, String extension, String runConfig, String flags, String filename) {
        this.compiler = compiler;
        this.extension = extension;
        this.runConfig = runConfig;
        this.flags = flags;
        this.filename = filename;
    }

    public String getCompiler() {
        return compiler;
    }

    public abstract boolean isObjectOriented();

    public String getExtension() {
        return extension;
    }

    public void setRunConfig(String runConfig) {
        this.runConfig = runConfig;
    }

    public void setExtension(String ext) {
        this.extension = extension;
    }

    public void setCompiler(String compiler) {
        this.compiler = compiler;
    }

    public String getFlags() {
        return flags;
    }

    public String getRunConfig() {
        return runConfig;
    }

    public void addFlag(String flag) {
        this.flags = flag;
    }

    public String getFilename() {
        return filename;
    }

    public boolean equals(Object o) {
        return (this.compiler == ((ProgrammingLanguage) o).getCompiler()) &&
                (this.flags == ((ProgrammingLanguage) o).getFlags()) &&
                (this.runConfig == ((ProgrammingLanguage) o).getRunConfig()) &&
                (this.isObjectOriented() == ((ProgrammingLanguage) o).isObjectOriented());
    }

    public String toString() {
        int index = 0;
        for (int i = 0; i < filename.length(); i++) {
            if (filename.charAt(i) == '.') {
                index = i;
                break;
            }
        }
        String fileFinder = filename.substring(index + 1);
        if (fileFinder.equalsIgnoreCase("java")) {
            return "Java";
        } else if (fileFinder.equalsIgnoreCase("c")) {
            return "C";
        } else if (fileFinder.equalsIgnoreCase("cpp")) {
            return "C++";
        } else if (fileFinder.equalsIgnoreCase("py")) {
            return "Python";
        } else {
            return "Unknown Programming Language";
        }
    }

    public abstract void printStrengths();

    public abstract void printWeaknesses();

}
