package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import domain.Free;
import repository.FreeDAO;

public class FreeJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		Free free = FreeDAO.getInstance().hitTop1();
		
		String fileName = "top.txt";
		String dir = "C:\\BoardProject";
		
		File file = new File(dir, fileName);
		
		if(file.exists()) {
			file.delete();
		}
		
		BufferedWriter bw = null;
		
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("게시글번호 " + free.getFreeNo() + "\n");
			sb.append("작성자 " + free.getWriter() + "\n");
			sb.append("제목 " + free.getTitle() + "\n");
			sb.append("작성IP " + free.getIp() + "\n");
			sb.append("조회수 " + free.getHit() + "\n");
			sb.append("내용\n");
			sb.append(free.getContent());
			
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(sb.toString());
			
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) bw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

	}

