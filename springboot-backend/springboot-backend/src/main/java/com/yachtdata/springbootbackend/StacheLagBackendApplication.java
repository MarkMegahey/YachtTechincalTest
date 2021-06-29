package com.yachtdata.springbootbackend;

import com.yachtdata.springbootbackend.model.Position;
import com.yachtdata.springbootbackend.model.Team;
import com.yachtdata.springbootbackend.repository.PositionRepository;
import com.yachtdata.springbootbackend.repository.TeamRepository;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StacheLagBackendApplication implements CommandLineRunner {
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private PositionRepository positionRepository;

	public StacheLagBackendApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(StacheLagBackendApplication.class, args);
	}

	public void run(String... args) throws Exception {
		JSONParser jsonParser = new JSONParser();
		String filePath = (new File("")).getAbsolutePath();

		try {
			FileReader reader = new FileReader(filePath + "/springboot-backend/src/main/resources/data/positions.json");

			try {
				Object obj = jsonParser.parse(reader);
				JSONObject teamsData = (JSONObject)obj;
				JSONArray teams = (JSONArray)teamsData.get("teams");
				teams.forEach((team) -> {
					this.parseTeamObject((JSONObject)team);
				});
			} catch (Throwable var9) {
				try {
					reader.close();
				} catch (Throwable var8) {
					var9.addSuppressed(var8);
				}

				throw var9;
			}

			reader.close();
		} catch (FileNotFoundException var10) {
			var10.printStackTrace();
		} catch (IOException var11) {
			var11.printStackTrace();
		} catch (ParseException var12) {
			var12.printStackTrace();
		}

	}

	private void parseTeamObject(JSONObject team) {
		Team newTeam = new Team((Long)team.get("marker"), (String)team.get("name"), (Long)team.get("serial"));
		this.teamRepository.save(newTeam);
		JSONArray positions = (JSONArray)team.get("positions");
		positions.forEach((position) -> {
			this.parsePositionObject(newTeam, (JSONObject)position);
		});
	}

	private void parsePositionObject(Team newTeam, JSONObject position) {
		this.positionRepository.save(new Position(newTeam, position));
	}
}

