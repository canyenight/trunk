require 'yaml'

require 'erb'



class SeleniumOnRailsConfig

  @@defaults = {:environments => 'test'}

  def self.get var, default = nil

    value = configs[var.to_s]

    value ||= @@defaults[var]

    value ||= default

    value ||= yield if block_given?

    value

  end



  private

  def self.configs

    unless defined? @@configs

      file = File.expand_path(File.dirname(__FILE__) + '/../config.yml')

      @@configs = File.exist?(file) ? YAML.load(ERB.new(IO.read(file)).result) : {}

    end

    @@configs

  end



end